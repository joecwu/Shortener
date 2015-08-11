package com.joecwu.shortener.hash

import com.joecwu.shortener.db.DBClient
import com.joecwu.shortener.exception._
import org.scalactic._
import java.security._
import java.math._
import scalaz._
import Scalaz._

/**
 * Created by Joe_Wu on 8/5/15.
 */
trait Shortener extends com.joecwu.shortener.Shortener {

  def shorter(url:String)(implicit tracerInfo: TracerInfo) = Reader((dbClient : DBClient) => {
    dbClient.getShorter(url).flatMap{ shorterInDB =>
      shorterInDB.map(Good(_)).getOrElse{
        // generate new one.
        val digest = MessageDigest.getInstance("sha")
        digest.update(url.getBytes())
        val shorter = new BigInteger(1,digest.digest()).toString(16)
        dbClient.save(url,shorter).flatMap{ _ =>
          Good(shorter)
        }
      }
    }
  })

  def taller(short:String)(implicit tracerInfo: TracerInfo) = Reader((dbClient : DBClient) => {
    dbClient.getUrl(short)
  })
}

object Shortener extends Shortener

