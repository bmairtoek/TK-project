using Generator2.Model;
using Generator2.TemperatureGenerators;
using System;
using System.Threading;

namespace Generator2
{
    class Program
    {
        static void Main(string[] args)
        {
            ITemperatureGenerator temperatureGenerator = new FakeTemperatureGenerator();
            //ITemperatureGenerator temperatureGenerator = new WmiTemperatureGenerator();   //requires running OpenHardwareMonitor
            var messageHandler = new MessageHandler();

            while (true)
            {
                Thread.Sleep(Convert.ToInt32(Constants.MESSAGE_INTERVAL * 1000));
                double temperature = temperatureGenerator.GetCurrentTemperature();
                Console.WriteLine(temperature);
                Console.WriteLine(new TemperatureModel(temperature).ToJson());
                messageHandler.Send(new TemperatureModel(temperature).ToJson());  
            }
        }
    }
}
