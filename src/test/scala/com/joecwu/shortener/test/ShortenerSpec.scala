package com.joecwu.shortener.test

import com.joecwu.shortener.Logger
import com.joecwu.shortener.db.memory.MemoryDBClient
import com.joecwu.shortener.exception.TracerInfo
import org.scalactic.{Bad, Good}
import org.scalatest._
import com.joecwu.shortener.hash.Shortener._
/**
 * Created by Joe_Wu on 8/5/15.
 */
class ShortenerSpec extends FlatSpec with Logger {

  behavior of "Shortener work with SHA & MemoryDB"
  implicit val dbClient = MemoryDBClient
  implicit val traceInfo = TracerInfo("MyTracerId")

  it should "get shorter with url http://www.google.com" in {
    val url = "http://www.google.com"
    val short = shorter(url) match {
      case Good(s) => s
      case Bad(ex) => log.error(ex.getMessage);""
    }
    log.debug(s"url:[$url] short:[$short]")
    assert(short.length > 0)
  }

  it should "get shorter with url http://www.google.com twice with the same result" in {
    val url = "http://www.google.com"
    val short1 = shorter(url).getOrElse("")
    val short2 = shorter(url).getOrElse("")
    log.debug(s"url:[$url] short1:[$short1] short2:[$short2]")
    assertResult(short1)(short2)
  }

  it should "get original url by using given shorter string" in {
    val url = "http://www.google.com"
    val short = shorter(url).getOrElse("")
    val url2 = taller(short).getOrElse("")
    log.debug(s"url:[$url] short:[$short] url2:[$url2]")
    assertResult(url)(url2)
  }

}
