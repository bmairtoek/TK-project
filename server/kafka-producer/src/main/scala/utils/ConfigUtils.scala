package utils

import com.typesafe.config.ConfigFactory

trait ConfigUtils {
  private val config = ConfigFactory.load().getConfig("kafka")

  def fromConfig(parameter: String): String = config.getString(parameter)
}
