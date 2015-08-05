package com.joecwu.shortener.db.redis

import com.joecwu.shortener.exception.{TracerInfo, DBException}
import org.scalactic._

/**
 * Created by Joe_Wu on 8/5/15.
 */
trait RedisDBClient extends com.joecwu.shortener.db.DBClient {
  //TODO RedisDBClient implementation
  def save(url:String,shorter:String)(implicit tracerInfo: TracerInfo) : Unit Or DBException = {
    Bad(DBException("Not Implemented yet."))
  }
  def getUrl(shorter:String)(implicit tracerInfo: TracerInfo) : String Or DBException = {
    Bad(DBException("Not Implemented yet."))
  }
  def getShorter(url:String)(implicit tracerInfo: TracerInfo) : Option[String] Or DBException = {
    Bad(DBException("Not Implemented yet."))
  }
}

object RedisDBClient extends RedisDBClient