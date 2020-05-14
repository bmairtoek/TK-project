import random

class FakeTemperatureGenerator:
    def getCurrentTemperature(self):
        return(random.randint(300,400)/10)   
