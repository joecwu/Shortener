package com.joecwu.shortener.db.memory

import com.joecwu.shortener.exception._
import org.scalactic._

import scala.collection.mutable

/**
 * Created by Joe_Wu on 8/5/15.
 */
trait MemoryDBClient extends com.joecwu.shortener.db.DBClient {
  val storeU2S = mutable.Map[String,String]()
  val storeS2U = mutable.Map[String,String]()

  def save(url:String,shorter:String)(implicit tracerInfo: TracerInfo) : Unit Or DBException = {
    try {
      storeU2S.put(url, shorter)
      storeS2U.put(shorter, url)
      Good()
    }catch{
      case ex:Throwable => Bad(DBException(s"insert failed. url:[$url] shorter:[$shorter]",ex))
    }
  }
  def getUrl(shorter:String)(implicit tracerInfo: TracerInfo) : String Or DBException = {
    storeS2U.get(shorter).map(Good(_)).getOrElse( Bad(ShorterNotInDBException(s"No Url for shorter:[$shorter]")) )
  }
  def getShorter(url:String)(implicit tracerInfo: TracerInfo) : Option[String] Or DBException = {
    Good(storeU2S.get(url))
  }
}

object MemoryDBClient extends MemoryDBClient