using System;
using System.Collections.Generic;
using System.Text;

namespace Generator2.Model
{
    interface IModel
    {
        object value
        {
            get; 
            set;
        }

        string ToJson();
    }
}
