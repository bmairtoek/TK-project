import requests
import threading

import constants

class MessageHandler:
    def send(self, data):
        threading.Thread(target=self.createRequest, args=(data)).start()
        # print(request.text)

    def createRequest(self, data):
        return requests.post(constants.END_POINT_ADDRESS, json=data)