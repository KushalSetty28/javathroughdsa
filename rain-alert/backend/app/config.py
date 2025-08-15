import os
from dotenv import load_dotenv

load_dotenv(os.path.join(os.path.dirname(os.path.dirname(__file__)), '..', '.env'))

DATABASE_URL = os.getenv('DATABASE_URL', 'sqlite:////workspace/rain-alert/data/app.db')
DATA_CSV_PATH = os.getenv('DATA_CSV_PATH', '/workspace/rain-alert/data/rainfall.csv')
ALERT_HOUR_LOCAL = int(os.getenv('ALERT_HOUR_LOCAL', '7'))
ADMIN_API_KEY = os.getenv('ADMIN_API_KEY')

TWILIO_ACCOUNT_SID = os.getenv('TWILIO_ACCOUNT_SID')
TWILIO_AUTH_TOKEN = os.getenv('TWILIO_AUTH_TOKEN')
TWILIO_FROM_NUMBER = os.getenv('TWILIO_FROM_NUMBER')