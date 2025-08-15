from fastapi import FastAPI, Depends, UploadFile, File, HTTPException, Header
from fastapi.responses import HTMLResponse, FileResponse
from fastapi.staticfiles import StaticFiles
from sqlalchemy.orm import Session
import os
import csv
from .db import Base, engine, get_db
from .models import Subscriber, AlertLog
from .schemas import SubscriberCreate, SubscriberOut, UploadResponse, PredictionOut, AlertSendRequest, AlertLogOut
from .ml import RainPredictor
from .alerts import dispatch_alert
from .scheduler import get_scheduler_singleton
from .config import DATA_CSV_PATH, ADMIN_API_KEY

app = FastAPI(title="Rain Alert API")

# Create tables
Base.metadata.create_all(bind=engine)

# Mount frontend static files
FRONTEND_DIR = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', '..', 'frontend'))
app.mount('/assets', StaticFiles(directory=FRONTEND_DIR), name='assets')

@app.get('/', response_class=HTMLResponse)
def index_page():
	index_path = os.path.join(FRONTEND_DIR, 'index.html')
	if os.path.exists(index_path):
		return FileResponse(index_path)
	return HTMLResponse('<h1>Rain Alert</h1><p>Frontend not found.</p>')


@app.post('/api/data/upload', response_model=UploadResponse)
def upload_data(file: UploadFile = File(...), x_api_key: str | None = Header(default=None)):
	if ADMIN_API_KEY and x_api_key != ADMIN_API_KEY:
		raise HTTPException(status_code=401, detail='Unauthorized')
	try:
		# Read incoming CSV content
		content = file.file.read().decode('utf-8')
		lines = [line for line in content.splitlines() if line.strip()]
		if not lines:
			raise HTTPException(status_code=400, detail='Empty file')
		reader = csv.DictReader(lines)
		if not reader.fieldnames or 'date' not in reader.fieldnames or 'rainfall_mm' not in reader.fieldnames:
			raise HTTPException(status_code=400, detail='CSV must have columns: date,rainfall_mm')
		rows = list(reader)
		# Basic validation
		valid_rows = []
		for row in rows:
			if 'date' in row and 'rainfall_mm' in row and row['date'] and row['rainfall_mm']:
				valid_rows.append((row['date'], row['rainfall_mm']))
		if not valid_rows:
			raise HTTPException(status_code=400, detail='No valid rows found')
		# Write normalized CSV
		os.makedirs(os.path.dirname(DATA_CSV_PATH), exist_ok=True)
		with open(DATA_CSV_PATH, 'w', newline='') as f:
			writer = csv.writer(f)
			writer.writerow(['date', 'rainfall_mm'])
			for d, v in valid_rows:
				writer.writerow([d, v])
		return UploadResponse(rows=len(valid_rows), message='Data uploaded')
	except HTTPException:
		raise
	except Exception as exc:  # noqa: BLE001
		raise HTTPException(status_code=400, detail=str(exc))


@app.get('/api/predict', response_model=PredictionOut)
def predict():
	model = RainPredictor()
	model.load()
	next_date, pred, conf = model.predict_next_day()
	return PredictionOut(date=str(next_date), rainfall_mm=pred, confidence=conf)


@app.post('/api/subscribers', response_model=SubscriberOut)
def add_subscriber(payload: SubscriberCreate, db: Session = Depends(get_db)):
	existing = db.query(Subscriber).filter(Subscriber.phone_e164 == payload.phone_e164).first()
	if existing:
		existing.name = payload.name
		existing.active = True
		db.commit()
		db.refresh(existing)
		return existing
	new = Subscriber(phone_e164=payload.phone_e164, name=payload.name, active=True)
	db.add(new)
	db.commit()
	db.refresh(new)
	return new


@app.get('/api/subscribers', response_model=list[SubscriberOut])
def list_subscribers(db: Session = Depends(get_db)):
	return db.query(Subscriber).order_by(Subscriber.id.desc()).all()


@app.post('/api/alerts/send', response_model=list[AlertLogOut])
def send_alerts(req: AlertSendRequest, db: Session = Depends(get_db), x_api_key: str | None = Header(default=None)):
	if ADMIN_API_KEY and x_api_key != ADMIN_API_KEY:
		raise HTTPException(status_code=401, detail='Unauthorized')
	model = RainPredictor()
	model.load()
	next_date, pred, conf = model.predict_next_day()
	if pred < req.threshold_mm:
		return []
	subscribers = db.query(Subscriber).filter(Subscriber.active == True).all()  # noqa: E712
	out: list[AlertLogOut] = []
	for sub in subscribers:
		message = f"Rain alert for {next_date}: predicted {pred:.1f} mm (confidence {conf:.0%})."
		dispatch_alert(db, sub.id, sub.phone_e164, message, pred)
	out_logs = db.query(AlertLog).order_by(AlertLog.id.desc()).limit(len(subscribers)).all()
	return out_logs


@app.get('/api/alerts/logs', response_model=list[AlertLogOut])
def list_alert_logs(db: Session = Depends(get_db), x_api_key: str | None = Header(default=None)):
	if ADMIN_API_KEY and x_api_key != ADMIN_API_KEY:
		raise HTTPException(status_code=401, detail='Unauthorized')
	return db.query(AlertLog).order_by(AlertLog.id.desc()).limit(200).all()


# Start scheduler on startup
@app.on_event('startup')
def on_startup():
	get_scheduler_singleton()