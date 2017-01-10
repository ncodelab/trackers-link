name := "trackers-link"

version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.8.4"
libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.8.4"
libraryDependencies +=  "org.scalaj" %% "scalaj-http" % "2.3.0"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
