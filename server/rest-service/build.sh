cd ./rest-service
mvn clean package -DskipTests
docker build -t rest_server:0.1 .
cd ..
