package kafka

import akka.actor.{Actor, Props}
import kafka.TemperatureStatisticsProducer.TemperatureStatistic
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.logging.log4j.scala.Logging


class TemperatureStatisticsProducer extends Actor with KafkaProduzer with Logging {
  override def receive: Receive = {
    case TemperatureStatistic(topic, senz) =>

      val record = new ProducerRecord[String, String](topic, senz)
      producer.send(record)

      logger.info(s"Produced message $senz to $topic")
  }
}

object TemperatureStatisticsProducer {

  def props = Props(classOf[TemperatureStatisticsProducer])

  case class TemperatureStatistic(topic: String, value: String)

}
