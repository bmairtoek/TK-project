class TemperaturData:
    def __init__(self, temperature):
        self.temperature = temperature

    def toJson(self):
        return {"temperature": self.temperature}