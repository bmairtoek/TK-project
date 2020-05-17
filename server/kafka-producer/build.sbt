name := "kafka-producer"

version := "0.1"

scalaVersion := "2.12.2"

libraryDependencies ++= {
  val akkaVersion = "2.5.23"
  val kafkaVesion = "0.10.1.0"

  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
    "com.typesafe.akka" %% "akka-stream" % akkaVersion,
    "org.apache.kafka" % "kafka-clients" % kafkaVesion,
//    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",
    "org.mongodb.scala" %% "mongo-scala-driver" % "2.2.1",
    "com.typesafe" % "config" % "1.2.1",


  //   logging
    "org.apache.logging.log4j" %% "log4j-api-scala" % "11.0",
    "org.apache.logging.log4j" % "log4j-api" % "2.11.0",
    "org.apache.logging.log4j" % "log4j-core" % "2.11.0" % Runtime,
    "ch.qos.logback" % "logback-classic" % "1.1.3" % Runtime,
//    "org.slf4j" % "slf4j-simple" % "1.7.12",

    //tests
    "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test"

  )
}
