from apscheduler.schedulers.background import BackgroundScheduler
from datetime import datetime, time, timedelta
from sqlalchemy.orm import Session
from .db import SessionLocal
from .models import Subscriber
from .ml import RainPredictor
from .alerts import dispatch_alert
from .config import ALERT_HOUR_LOCAL


class AlertScheduler:
	def __init__(self):
		self.scheduler = BackgroundScheduler()
		self.predictor = RainPredictor()

	def start(self):
		self.scheduler.start()
		# Schedule at ALERT_HOUR_LOCAL local time each day
		alert_time = time(hour=ALERT_HOUR_LOCAL, minute=0)
		self.scheduler.add_job(self.run_daily, 'cron', hour=alert_time.hour, minute=alert_time.minute, id='daily_alert')

	def run_daily(self, threshold_mm: float = 1.0):
		db: Session = SessionLocal()
		try:
			self.predictor.load()
			next_date, pred, conf = self.predictor.predict_next_day()
			if pred < threshold_mm:
				return

			subscribers = db.query(Subscriber).filter(Subscriber.active == True).all()  # noqa: E712
			for sub in subscribers:
				message = f"Rain alert for {next_date}: predicted {pred:.1f} mm (confidence {conf:.0%})."
				dispatch_alert(db, sub.id, sub.phone_e164, message, pred)
		finally:
			db.close()


def get_scheduler_singleton():
	# Simple module-level singleton
	global _SCHED
	try:
		return _SCHED
	except NameError:
		_SCHED = AlertScheduler()
		_SCHED.start()
		return _SCHED