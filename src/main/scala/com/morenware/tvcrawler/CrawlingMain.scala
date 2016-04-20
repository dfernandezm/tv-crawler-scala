package com.morenware.tvcrawler

/**
 * Created by david on 18/04/2016.
 */

import java.io.File
import com.lambdaworks.jacks.JacksMapper
import io._
import net.liftweb.json._

case class Config(crawlerConf: File = new File("."))
case class WebsiteSection()
case class CrawlerConfig(name: String, siteId: String, baseUrl: String, sections: List[WebsiteSection])
case class CrawlersConfig (crawlers: List[CrawlerConfig])

object CrawlingMain {

  def main(args: Array[String]) = {
    readConfigFromFile()
    //readCommandLineArguments(args)
  }

  def readConfigFromFile(): Unit = {

    val source = Source.fromFile("config.json")
    val lines = try source.mkString finally source.close()
    println("Lines: \n" + lines)

    implicit val formats = DefaultFormats

    val json = parse(lines)

    val config: CrawlersConfig = json.extract[CrawlersConfig]

    config.crawlers.foreach( crawler => {
      println(crawler.baseUrl)
      println(crawler.name)
      println(crawler.siteId)
    })
  }

  def readCommandLineArguments(args: Array[String]): Unit = {

    val parser = new scopt.OptionParser[Config]("scopt") {
      head("tvCrawler", "0.1")
      opt[File]('c', "conf") required() valueName("<confFile.json>") action { (x, c) =>
        c.copy(crawlerConf = x) } text("conf requires a json configuration file")
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
}
