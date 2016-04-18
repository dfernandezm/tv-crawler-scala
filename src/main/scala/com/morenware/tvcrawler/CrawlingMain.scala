package com.morenware.tvcrawler

/**
 * Created by david on 18/04/2016.
 */

import java.io.File

case class Config(crawlerConf: File = new File("."))

object CrawlingMain {

  def main(args: Array[String]) = {
    //println("Hello, " + args(0))

    val parser = new scopt.OptionParser[Config]("scopt") {
      head("tvCrawler", "0.1")

      opt[File]('c', "conf") required() valueName("<confFile.json>") action { (x, c) =>
        c.copy(crawlerConf = x) } text("conf requires a json configuration file")
    }

    parser.parse(args, Config()) match {
      case Some(config) =>
        println("Read config: ", config.crawlerConf)
        val f = config.crawlerConf

      case None =>
        println("Bad Arguments")
      // arguments are bad, error message will have been displayed
    }

  }

}
