import time

import constants
from temperature_generators.wmi_temperature_generator import WmiTemperatureGenerator
from temperature_generators.fake_temperature_generator import FakeTemperatureGenerator
from message_handler import MessageHandler
from model.temperature_data import TemperaturData

# temperatureGenerator = WmiTemperatureGenerator() #requires OpenHardwareMonitor up and running
temperatureGenerator = FakeTemperatureGenerator()
messageHandler = MessageHandler()

start_time = time.time()
while True:
    time.sleep(constants.MESSAGE_INTERVAL)
    temperature = temperatureGenerator.getCurrentTemperature()
    print(temperature)
    print(TemperaturData(temperature).toJson())
    messageHandler.send(TemperaturData(temperature).toJson())   #still needs some fixing