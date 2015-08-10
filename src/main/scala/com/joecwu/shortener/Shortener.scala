package com.joecwu.shortener

import com.joecwu.shortener.db.DBClient
import com.joecwu.shortener.exception._
import org.scalactic._
import scalaz._
import Scalaz._

/**
 * Created by Joe_Wu on 8/5/15.
 */
trait Shortener {
  def shorter(url:String)(implicit tracerInfo: TracerInfo) : Reader[DBClient, String Or BaseException]
  def taller(short:String)(implicit tracerInfo: TracerInfo) : Reader[DBClient, String Or BaseException]
}

