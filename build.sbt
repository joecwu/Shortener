name := "shortener"

version := "0.2.0"

scalaVersion := "2.11.7"

crossScalaVersions := Seq("2.10.5","2.11.7")

resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.1.3"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.0.13"

libraryDependencies <++= scalaVersion(sv => Seq( grizzled(sv),scalatest(sv) ))

def grizzled(ver:String) =
  (ver match {
    case "2.9.3" => "org.clapper" % "grizzled-slf4j_2.9.2" % "0.6.10"
    case _ => "org.clapper" %% "grizzled-slf4j" % "1.0.2"
  })

def scalatest(ver:String) =
  (ver match {
    case "2.9.2" | "2.9.3" => "org.scalatest" %% "scalatest" % "1.9.2"
    case _ => "org.scalatest" %% "scalatest" % "2.2.5"
  })
