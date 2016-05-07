package com.morenware.tvcrawler.config

import java.io.File

import com.typesafe.scalalogging.Logger
import net.liftweb.json.DefaultFormats

import io._
import net.liftweb.json._
import org.slf4j.LoggerFactory
case class Config(crawlerConf: File = new File("."))

/**
 * Created by david on 20/04/2016.
 */
object Configuration {

  val log = Logger(LoggerFactory.getLogger("crawlers"))

  def readConfigFromFile(): CrawlersConfig = {

    val source = Source.fromFile("config.json")
    val lines = try source.mkString finally source.close()

    log.debug(s"**** Configuration is: $lines")

    implicit val formats = DefaultFormats
    val json = parse(lines)
    val config: CrawlersConfig = json.extract[CrawlersConfig]

    // Log some values
    config.crawlers.foreach( crawler => {
      log.debug(s"***** Base url: ${crawler.baseUrl}" )
      log.debug(s"***** Name: ${crawler.name}" )
      log.debug(s"***** Site ID: ${crawler.siteId}" )
      log.debug(s"***** Section 1 link type: ${crawler.sections.head.torrentLinkType}" )
    })

    // Return this config
    config
  }

  def readCommandLineArguments(args: Array[String]): Unit = {

    val parser = new scopt.OptionParser[Config]("scopt") {
      head("tvCrawler", "0.1")
      opt[File]('c', "conf") required() valueName "<confFile.json>" action {
        (x, c) =>
          c.copy(crawlerConf = x) } text "conf requires a json configuration file"
        }

    parser.parse(args, Config()) match {

      case Some(config) =>
        println("Read config: ", config.crawlerConf)
        val f = config.crawlerConf.getName
        val source = Source.fromFile(f)
        val lines = try source.mkString finally source.close()
        println("Lines:\n" + lines);

      case None =>
        println("Bad Arguments")
      // arguments are bad, error message will have been displayed
    }
  }

// Try / catch example
//  try {
//    throw new NullPointerException()
//  } catch {
//
//    // Could use wildcard _, but that way cannot be used afterwards like I am doing here
//    case any: Throwable => log.error(s"Exception occurred: ${any.getMessage}")
//  }

}
