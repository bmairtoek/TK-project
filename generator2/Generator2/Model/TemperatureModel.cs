using System;
using System.Collections.Generic;
using System.Globalization;
using System.Text;
using Newtonsoft.Json;

namespace Generator2.Model
{
    class TemperatureModel : IModel
    {
        public string deviceId;
        public string date;

        private double _value;
        public object value { 
            get => _value; 
            set => _value = (double)value; 
        }

        public TemperatureModel(double value)
        {
            this.value = value;
            this.deviceId = Constants.DEVICE_ID;
            this.date = DateTime.UtcNow.ToString("s", CultureInfo.InvariantCulture);
        }

        public string ToJson()
        {
            return JsonConvert.SerializeObject(this);
        }
    }
}
