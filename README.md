# Shortener
URL Shortener library in Scala

## SBT users 

    libraryDependencies += "com.joecwu" % "shortener_2.11" % "0.1.0"

## Dependency

- [Scalactic](http://www.scalactic.org/)

## Usage

    import org.scalactic._
    import com.joecwu.shortener.hash.Shortener._
    import com.joecwu.shortener.db.memory.MemoryDBClient
    import com.joecwu.shortener.exception.TracerInfo
    
    implicit val dbClient = MemoryDBClient
    implicit val traceInfo = TracerInfo("CustomTracerId")
    val url = "http://www.google.com"
    val short = shorter(url).getOrElse("")
    val url2 = taller(short).getOrElse("")

## Design Concept

Detail design concept, refer to [Wiki - Design Concept](https://github.com/joecwu/shortener/wiki/Design-Concept).