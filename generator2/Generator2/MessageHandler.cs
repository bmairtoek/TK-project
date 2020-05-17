using System;
using System.Collections.Generic;
using System.Text;
using System.Net.Http;
using System.Net;
using System.IO;
using Generator2.Model;

namespace Generator2
{
    class MessageHandler
    {
        public void Send(string data)
        {
            var httpWebRequest = (HttpWebRequest)WebRequest.Create(Constants.END_POINT_ADDRESS);
            httpWebRequest.ContentType = "application/json";
            httpWebRequest.Method = "POST";

            using (var streamWriter = new StreamWriter(httpWebRequest.GetRequestStream()))
            {
                streamWriter.Write(data);
            }

            httpWebRequest.GetResponse();
        }
    }
}
