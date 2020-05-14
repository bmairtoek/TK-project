using System;
using System.Collections.Generic;
using System.Text;

namespace Generator2.TemperatureGenerators
{
    class FakeTemperatureGenerator: ITemperatureGenerator
    {
        private readonly Random rnd;

        public FakeTemperatureGenerator()
        {
            this.rnd = new Random();
        }

        public double GetCurrentTemperature()
        {
            return (double)rnd.Next(400, 500) / 10;
        }
    }
}
