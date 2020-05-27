FROM java:8-jdk-alpine

# working directory
WORKDIR /app

ADD target/data-storage-service-0.0.1-SNAPSHOT.jar rest_server.jar
ENTRYPOINT [ "java", "-jar", "/app/rest_server.jar" ]
