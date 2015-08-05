package com.joecwu.shortener.exception

import com.joecwu.shortener._
/**
 * Created by Joe_Wu on 8/5/15.
 */
case class TracerInfo(tid:String=java.util.UUID.randomUUID.toString)

class BaseException(msg : String = "", cause: Throwable = null)(implicit tracerInfo: TracerInfo) extends Exception(msg, cause) {
  val tid = tracerInfo.tid
}
class DBException(msg : String = "", cause: Throwable = null)(implicit tracerInfo: TracerInfo) extends BaseException(msg,cause)
case class ShorterNotInDBException(msg : String = "", cause: Throwable = null)(implicit tracerInfo: TracerInfo) extends DBException(msg,cause)

object BaseException extends Logger {
  implicit def ExceptionHandler(ex : BaseException) = new {
    def writeLog() = {
      log.error(s"Exception tracerId:[${ex.tid}] type:[${ex.getClass.getName}] msg:[${ex.getMessage}]")
      log.debug(s"Exception tracerId:[${ex.tid}] stackTrace: ${ex.getStackTraceString}")
    }
  }
}

object DBException {
  def apply(msg:String="",cause:Throwable=null)(implicit tracerInfo: TracerInfo) = new DBException(msg,cause)
}