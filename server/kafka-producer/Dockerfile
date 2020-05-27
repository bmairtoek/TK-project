FROM java:8-jdk-alpine

# set service variables
ENV KAFKA_HOST ${HOST_IP}
ENV KAFKA_PORT 9092

# working directory
WORKDIR /app

ADD target/scala-2.12/kafka-producer-assembly-0.1.jar kafka_temp.jar
ENTRYPOINT [ "java", "-jar", "/app/kafka_temp.jar" ]

