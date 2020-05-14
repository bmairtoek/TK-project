using System;
using System.Collections.Generic;
using System.Management;
using System.Text;
using OpenHardwareMonitor.Hardware;
using OpenHardwareMonitor.Collections;

namespace Generator2.TemperatureGenerators
{
    class WmiTemperatureGenerator : ITemperatureGenerator
    {
        private readonly Computer computer;
        public WmiTemperatureGenerator()
        {
            this.computer = new Computer
            {
                CPUEnabled = true
            };
        }

        public double GetCurrentTemperature()
        {
            computer.Open();

            if (computer.Hardware.Length > 0)
            {
                for (int j = 0; j < computer.Hardware[0].Sensors.Length; j++)
                {
                    if (computer.Hardware[0].Sensors[j].SensorType == SensorType.Temperature)
                    {
                        double result = Convert.ToDouble(computer.Hardware[0].Sensors[j].Value);
                        computer.Close();
                        return result;
                    }
                }
            }
            throw new MissingFieldException();
        }
    }
}
