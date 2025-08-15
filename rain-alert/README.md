# Rain Alert: Next-Day Rainfall Prediction and SMS Alerts

## Quickstart

1. Create and populate a virtual environment

```bash
cd /workspace/rain-alert/backend
python -m venv .venv
source .venv/bin/activate
pip install -r requirements.txt
```

2. Configure environment variables

- Copy `.env.example` to `.env` and edit values:

```bash
cp ../.env.example ../.env
```

3. Run the backend server

```bash
uvicorn app.main:app --reload --host 0.0.0.0 --port 8000
```

4. Open the web UI

- Visit `http://localhost:8000/`

5. Upload rainfall data (CSV)

- Use the UI or `POST /api/data/upload` with a CSV file containing columns: `date` (YYYY-MM-DD) and `rainfall_mm` (float).

6. Subscribe a phone number

- Use the UI. If Twilio env vars are not set, alerts will be logged to server console instead of SMS.

## Environment Variables

See `.env.example` for all vars.

- `DATABASE_URL` (default: `sqlite:////workspace/rain-alert/data/app.db`)
- `DATA_CSV_PATH` (default: `/workspace/rain-alert/data/rainfall.csv`)
- `ALERT_HOUR_LOCAL` (default: `07`)
- `TWILIO_ACCOUNT_SID`, `TWILIO_AUTH_TOKEN`, `TWILIO_FROM_NUMBER` (optional)
- `ADMIN_API_KEY` (optional; protects admin endpoints if set)

## Notes

- Prediction uses a lightweight weighted moving-average over recent days. You can replace `app/ml.py` with a richer model later.
- Scheduler sends daily alerts around `ALERT_HOUR_LOCAL`.