package com.morenware.tvcrawler

/**
 * Created by david on 18/04/2016.
 */

import java.io.File
import com.lambdaworks.jacks.JacksMapper
import io._
import scala.util.parsing.json.JSON

case class Config(crawlerConf: File = new File("."))

object CrawlingMain {

  def main(args: Array[String]) = {
    readConfigFromFile()
    //readCommandLineArguments(args)
  }

  def readConfigFromFile(): Unit = {
    val f = new File("/tmp/config.json")
    val source = Source.fromFile("/tmp/config.json")
    val lines = try source.mkString finally source.close()
    println("Lines: \n" + lines)
    val rawJson = JSON.parseFull(lines)
    val json = rawJson.asInstanceOf[Option[Map[String,List[Map[String,String]]]]]
    println("Json: ", json)
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
