curl \
    --header "Content-type: application/json" \
    --request POST \
    --data '{"deviceId":123, "value":900.00, "date":"2020-03-20"}' \
    http://localhost:8080//measurement/temperature