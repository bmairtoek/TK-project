import json
import constants
from datetime import datetime, tzinfo, timedelta

class TemperaturData:
    def __init__(self, temperature):
        self.temperature = temperature

    def toJson(self):
        return {"deviceId": constants.DEVICE_ID, "value": self.temperature, "date": datetime.utcnow().replace(tzinfo=simple_utc()).isoformat()}

class simple_utc(tzinfo):
    def tzname(self,**kwargs):
        return "UTC"
    def utcoffset(self, dt):
        return timedelta(0)