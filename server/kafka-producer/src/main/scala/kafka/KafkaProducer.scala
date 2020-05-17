package kafka

import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig}
import org.apache.kafka.common.serialization.StringSerializer
import utils.ConfigUtils

trait TempStatisticsKafkaProducer extends ConfigUtils {
  lazy val props = new Properties()
  props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
    fromConfig("host").concat(":").concat(fromConfig("port")))
  props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer].getCanonicalName)
  props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer].getCanonicalName)
  props.put(ProducerConfig.RETRIES_CONFIG, "5")

  lazy val producer = new KafkaProducer[String, String](props)
}

