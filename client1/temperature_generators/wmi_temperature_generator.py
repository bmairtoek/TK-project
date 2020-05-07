import wmi
import constants

class WmiTemperatureGenerator:
    def __init__(self):
        self.W = wmi.WMI(namespace="root/OpenHardwareMonitor")

    def getCurrentTemperature(self):
        for sensor in self.W.Sensor():
            if sensor.SensorType==u'Temperature' and sensor.Name==constants.WMI_SENSOR_NAME:
                return sensor.Value       
