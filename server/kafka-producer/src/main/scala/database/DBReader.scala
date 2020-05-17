package database

import database.DBReader.getMongoClient
import database.Helpers._
import org.mongodb.scala._
import org.mongodb.scala.bson.BsonDocument
import utils.ConfigUtils

class DBReader extends ConfigUtils {
  def getMeanTemp(): Double = {
    val tempValues = findCollection(fromConfig("tempDatabase"), fromConfig("collectionName"))
    calculateMeanValue(tempValues, "value")
  }

  def calculateMeanValue(temperatureReads: Seq[BsonDocument], key: String): Double = {
    temperatureReads.map(x => x.getDouble(key).doubleValue())
      .foldLeft(0.0)((a, b) => a + b) / temperatureReads.length
  }

  def findCollection(databaseName: String, collectionName: String): Seq[BsonDocument] = {
    val mongoClient: MongoClient = getMongoClient
    val database: MongoDatabase = mongoClient.getDatabase(databaseName)
    val collection: MongoCollection[BsonDocument] = database.getCollection(collectionName)
    collection.find().results()
  }
}

object DBReader extends ConfigUtils {
  val mongoClient: MongoClient = MongoClient("mongodb://"
    .concat(fromConfig("mongoHost"))
    .concat(":")
    .concat(fromConfig("mongoPort")))

  def getMongoClient: MongoClient = mongoClient
}
