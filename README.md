# Shortener
URL Shortener library in Scala

## SBT users 

    libraryDependencies += "com.joecwu" %% "shortener" % "0.2.0"

## Dependency

- [Scalaz](https://github.com/scalaz/scalaz)
- [Scalactic](http://www.scalactic.org/)

## Usage

    import org.scalactic._
    import com.joecwu.shortener.hash.Shortener._
    import com.joecwu.shortener.db.memory.MemoryDBClient
    import com.joecwu.shortener.exception.TracerInfo
    
    val dbClient = MemoryDBClient
    implicit val traceInfo = TracerInfo("CustomTracerId")
    val url = "http://www.google.com"
    // both shorter & taller are [Reader Monad](https://gist.github.com/joecwu/3e1461d7fb1df268c482)
    val short = shorter(url)(dbClient).getOrElse("")
    val url2 = taller(short)(dbClient).getOrElse("")

## Design Concept

Detail design concept, refer to [Wiki - Design Concept](https://github.com/joecwu/shortener/wiki/Design-Concept).