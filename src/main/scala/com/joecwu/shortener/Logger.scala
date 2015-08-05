package com.joecwu.shortener

import grizzled.slf4j.Logger

/**
 * Created by Joe_Wu on 8/5/15.
 */
trait Logger {
  lazy val log = Logger(this.getClass.getName)
}
