using System;
using System.Collections.Generic;
using System.Text;

namespace Generator2.TemperatureGenerators
{
    interface ITemperatureGenerator
    {
        double GetCurrentTemperature();
    }
}
