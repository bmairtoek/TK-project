import requests
import threading

import constants

class MessageHandler:
    def send(self, data):
        header = {'Content-type': 'application/json'}
        return requests.post(constants.END_POINT_ADDRESS, headers=header, json=data)