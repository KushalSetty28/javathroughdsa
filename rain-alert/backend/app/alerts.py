from typing import Optional
from twilio.rest import Client
from .config import TWILIO_ACCOUNT_SID, TWILIO_AUTH_TOKEN, TWILIO_FROM_NUMBER
from sqlalchemy.orm import Session
from .models import AlertLog


def send_sms(phone_e164: str, message: str) -> tuple[bool, Optional[str]]:
	if TWILIO_ACCOUNT_SID and TWILIO_AUTH_TOKEN and TWILIO_FROM_NUMBER:
		try:
			client = Client(TWILIO_ACCOUNT_SID, TWILIO_AUTH_TOKEN)
			client.messages.create(to=phone_e164, from_=TWILIO_FROM_NUMBER, body=message)
			return True, None
		except Exception as exc:  # noqa: BLE001
			return False, str(exc)
	else:
		print(f"[SMS FAKE] to={phone_e164} msg={message}")
		return True, None


def dispatch_alert(db: Session, subscriber_id: int, phone_e164: str, message: str, predicted_mm: Optional[float]):
	ok, err = send_sms(phone_e164, message)
	log = AlertLog(subscriber_id=subscriber_id, predicted_mm=predicted_mm, message=message, sent_ok=ok, error=err)
	db.add(log)
	db.commit()
	return ok, err