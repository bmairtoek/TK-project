using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace Generator2.Model
{
    class TemperatureModel : IModel
    {
        private double _value;
        public object Value { 
            get => _value; 
            set => _value = (double)value; 
        }

        public TemperatureModel(double value)
        {
            this.Value = value;
        }

        public string ToJson()
        {
            return JsonConvert.SerializeObject(this);
        }
    }
}
