package kafka

import akka.actor.{Actor, Props}
import kafka.TemperatureStatisticsProducer.TemperatureStatistic
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.logging.log4j.scala.Logging


class TemperatureStatisticsProducer extends Actor with TempStatisticsKafkaProducer with Logging {
  override def receive: Receive = {
    case TemperatureStatistic(topic, message) =>

      val record = new ProducerRecord[String, String](topic, message)
      producer.send(record)

      logger.info(s"Produced message $message to $topic")
  }
}

object TemperatureStatisticsProducer {

  def props = Props(classOf[TemperatureStatisticsProducer])

  case class TemperatureStatistic(topic: String, value: String)

}
