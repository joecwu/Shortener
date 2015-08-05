// Your profile name of the sonatype account. The default is the same with the organization value
sonatypeProfileName := "com.joecwu"

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

organization := "com.joecwu"

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra in Global := (
  <url>http://github.com/joecwu/shortener</url>
    <licenses>
      <license>
        <name>Apache License, Version 2.0</name>
        <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <url>https://github.com/joecwu/shortener</url>
      <connection>scm:git:git://github.com/joecwu/shortener.git</connection>
      <developerConnection>scm:git:git@github.com:joecwu/shortener.git</developerConnection>
    </scm>
    <developers>
      <developer>
        <id>joecwu</id>
        <name>Joe Wu</name>
        <email>joecwu@gmail.com</email>
        <url>https://github.com/joecwu</url>
      </developer>
    </developers>
  )