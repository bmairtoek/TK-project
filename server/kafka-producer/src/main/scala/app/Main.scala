package app

import akka.actor.ActorSystem
import database.DBReader
import kafka.TemperatureStatisticsProducer

object Main extends App {
  val dataBase = new DBReader

  implicit val system = ActorSystem("temp")
  val producer = system.actorOf(TemperatureStatisticsProducer.props, name = "TempStatistics")

  while (true) {
    producer ! TemperatureStatisticsProducer.TemperatureStatistic("temp", "mean temperature is : %s".format(dataBase.getMeanTemp()))
    Thread.sleep(5000)
  }
}
