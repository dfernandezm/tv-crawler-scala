name := "tvCrawler"

version := "1.0"

scalaVersion := "2.11.8"

retrieveManaged := true

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.4.1"

libraryDependencies += "joda-time" % "joda-time" % "2.9.1"

libraryDependencies += "net.ruippeixotog" %% "scala-scraper" % "1.0.0"

libraryDependencies += "com.github.scopt" %% "scopt" % "3.4.0"

libraryDependencies += "com.lambdaworks" % "jacks_2.11" % "2.3.3"

//resolvers += Resolver.sonatypeRepo("public")

