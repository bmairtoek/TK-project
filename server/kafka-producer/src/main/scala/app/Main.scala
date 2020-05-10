package app

import akka.actor.ActorSystem
import database.DBReader
import kafka.TemperatureStatisticsProducer

object Main extends App {

  val db = new DBReader
  db.findCollection("dataStorageAppDB", "measurements_temperature")

  implicit val system = ActorSystem("temp")
  val producer = system.actorOf(TemperatureStatisticsProducer.props, name = "TempStatistics")
  producer ! TemperatureStatisticsProducer.TemperatureStatistic("temp", "mean temperature is : %s".format(db.getMeanTemp()))
  producer ! TemperatureStatisticsProducer.TemperatureStatistic("temp", "mean temperature is : %s".format(db.getMeanTemp()))
  producer ! TemperatureStatisticsProducer.TemperatureStatistic("temp", "mean temperature is : %s".format(db.getMeanTemp()))
  producer ! TemperatureStatisticsProducer.TemperatureStatistic("temp", "mean temperature is : %s".format(db.getMeanTemp()))
  producer ! TemperatureStatisticsProducer.TemperatureStatistic("temp", "mean temperature is : %s".format(db.getMeanTemp()))
}
