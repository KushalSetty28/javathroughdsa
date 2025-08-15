from sqlalchemy import Column, Integer, String, DateTime, Boolean, Float
from sqlalchemy.sql import func
from .db import Base


class Subscriber(Base):
	__tablename__ = 'subscribers'

	id = Column(Integer, primary_key=True, index=True)
	phone_e164 = Column(String(32), unique=True, index=True, nullable=False)
	name = Column(String(128), nullable=True)
	active = Column(Boolean, default=True, nullable=False)
	created_at = Column(DateTime(timezone=True), server_default=func.now())


class AlertLog(Base):
	__tablename__ = 'alert_logs'

	id = Column(Integer, primary_key=True, index=True)
	subscriber_id = Column(Integer, index=True, nullable=False)
	predicted_mm = Column(Float, nullable=True)
	message = Column(String(1024), nullable=False)
	sent_ok = Column(Boolean, default=False)
	error = Column(String(512))
	created_at = Column(DateTime(timezone=True), server_default=func.now())