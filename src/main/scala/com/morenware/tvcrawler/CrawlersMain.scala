package com.morenware.tvcrawler

/**
 * Created by david on 18/04/2016.
 */

import com.morenware.tvcrawler.config.Configuration
import com.morenware.tvcrawler.crawling.CrawlerManager

// Needs to extend App so it can be run from IDE
object CrawlersMain extends App {

  override def main(args: Array[String]) = {
    val config  = Configuration.readConfigFromFile()

    // First configuration in the list
    CrawlerManager.startCrawler(config.crawlers.head)

    //TODO: Use this
    //readCommandLineArguments(args)
  }
}
