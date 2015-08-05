package com.joecwu.shortener.db

import com.joecwu.shortener.exception._
import org.scalactic._
/**
 * Created by Joe_Wu on 8/5/15.
 */
trait DBClient {
  def save(url:String,shorter:String)(implicit tracerInfo: TracerInfo) : Unit Or DBException
  def getUrl(shorter:String)(implicit tracerInfo: TracerInfo) : String Or DBException
  def getShorter(url:String)(implicit tracerInfo: TracerInfo) : Option[String] Or DBException
}
