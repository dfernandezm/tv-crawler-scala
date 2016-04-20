package com.morenware.tvcrawler

/**
 * Created by david on 18/04/2016.
 */

import com.morenware.tvcrawler.config.{Configuration}

object CrawlersMain {

  def main(args: Array[String]) = {
    Configuration.readConfigFromFile()
    //readCommandLineArguments(args)
  }
}
