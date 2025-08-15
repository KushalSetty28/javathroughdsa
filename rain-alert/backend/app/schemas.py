from pydantic import BaseModel, Field
from typing import Optional, List


class SubscriberCreate(BaseModel):
	phone_e164: str = Field(..., description="E.164 formatted phone number, e.g., +15551234567")
	name: Optional[str] = None


class SubscriberOut(BaseModel):
	id: int
	phone_e164: str
	name: Optional[str]
	active: bool

	class Config:
		from_attributes = True


class UploadResponse(BaseModel):
	rows: int
	message: str


class PredictionOut(BaseModel):
	date: str
	rainfall_mm: float
	confidence: float


class AlertSendRequest(BaseModel):
	threshold_mm: float = Field(1.0, description="Send alerts if prediction >= threshold")


class AlertLogOut(BaseModel):
	id: int
	subscriber_id: int
	predicted_mm: float | None
	message: str
	sent_ok: bool
	error: Optional[str]

	class Config:
		from_attributes = True