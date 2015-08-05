package com.joecwu.shortener

import com.joecwu.shortener.db.DBClient
import com.joecwu.shortener.exception._
import org.scalactic._

/**
 * Created by Joe_Wu on 8/5/15.
 */
trait Shortener {
  def shorter(url:String)(implicit dbClient : DBClient, tracerInfo: TracerInfo) : String Or BaseException
  def taller(short:String)(implicit dbClient : DBClient, tracerInfo: TracerInfo) : String Or BaseException
}

