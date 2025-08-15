import csv
import math
from datetime import datetime, timedelta, date
from typing import List, Tuple
from .config import DATA_CSV_PATH


class RainPredictor:
	def __init__(self, csv_path: str | None = None):
		self.csv_path = csv_path or DATA_CSV_PATH
		self.data: List[Tuple[date, float]] = []

	def load(self) -> List[Tuple[date, float]]:
		records: List[Tuple[date, float]] = []
		try:
			with open(self.csv_path, 'r', newline='') as f:
				reader = csv.DictReader(f)
				if not reader.fieldnames or 'date' not in reader.fieldnames or 'rainfall_mm' not in reader.fieldnames:
					raise ValueError('CSV must have columns: date,rainfall_mm')
				for row in reader:
					try:
						d = datetime.strptime(row['date'], '%Y-%m-%d').date()
						v = float(row['rainfall_mm'])
						records.append((d, v))
					except Exception:
						continue
			records.sort(key=lambda x: x[0])
			self.data = records
			return self.data
		except FileNotFoundError:
			self.data = []
			return self.data

	def predict_next_day(self) -> tuple[date, float, float]:
		if not self.data:
			self.load()

		if not self.data:
			next_date = datetime.utcnow().date() + timedelta(days=1)
			return next_date, 0.0, 0.2

		# Use up to last 60 observations
		recent = self.data[-60:]
		values = [v for _, v in recent]
		if not values:
			next_date = (self.data[-1][0]) + timedelta(days=1)
			return next_date, 0.0, 0.2

		# Exponential weights from older to newer
		n = len(values)
		weights = [math.exp(-3.0 + 3.0 * (i / (n - 1))) if n > 1 else 1.0 for i in range(n)]
		sum_w = sum(weights)
		weights = [w / sum_w for w in weights]
		ema_pred = sum(v * w for v, w in zip(values, weights))

		# Day-of-week adjustment
		last_dates = [d for d, _ in recent]
		next_date = last_dates[-1] + timedelta(days=1)
		next_dow = next_date.weekday()
		dow_groups = {}
		for (d, v) in recent:
			dow_groups.setdefault(d.weekday(), []).append(v)
		dow_mean = (sum(dow_groups.get(next_dow, [ema_pred])) / max(1, len(dow_groups.get(next_dow, []))))
		pred = 0.6 * ema_pred + 0.4 * dow_mean

		# Confidence inversely related to recent variance (last 14 values)
		recent_tail = values[-14:] if len(values) >= 5 else values
		if len(recent_tail) <= 1:
			variance = 1.0
		else:
			m = sum(recent_tail) / len(recent_tail)
			variance = sum((x - m) ** 2 for x in recent_tail) / (len(recent_tail) - 1)
		confidence = max(0.2, 1.0 / (1.0 + variance))

		return next_date, max(0.0, float(pred)), float(confidence)