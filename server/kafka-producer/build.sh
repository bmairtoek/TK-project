sbt 'set test in assembly := {}' clean assembly
docker build --tag temp_kafka_producer:0.1 .