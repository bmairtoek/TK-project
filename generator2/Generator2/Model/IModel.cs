using System;
using System.Collections.Generic;
using System.Text;

namespace Generator2.Model
{
    interface IModel
    {
        object Value
        {
            get; 
            set;
        }

        string ToJson();
    }
}
