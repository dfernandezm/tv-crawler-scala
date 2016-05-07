package com.morenware.tvcrawler.crawling

import akka.actor.{ActorSystem, Props}
import com.morenware.tvcrawler.actors.{HtmlGet, PageRetriever}
import com.morenware.tvcrawler.config.CrawlerConfig
import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory

/**
  * Created by david on 05/05/2016.
  */
object CrawlerManager extends CrawlerUtils {

  val log = Logger(LoggerFactory.getLogger("crawlers"))

  def startCrawler(config: CrawlerConfig) = {

    log.info(s"Starting crawler for ${config.name}")
    log.info("Initializing actor system")

    val system = ActorSystem("CrawlingSystem")
    val pageRetriever = system.actorOf(Props[PageRetriever], name = "pageRetriever")

    config.sections.foreach { section =>

      log.info(s"Starting to crawl section: ${section.name}")

      //TODO: Generate this in the actor
      val sectionBaseLink = getInitialSectionLink(config.baseUrl, section.sectionLink,
        section.listModeParameter + section.orderByDateParameter)

      log.debug("Sending message to retriever actor...")
      pageRetriever ! HtmlGet(sectionBaseLink, section.name)

      log.debug("===>> Back from retriever call (should be non block) <<====")

      //TODO: create relevant actors
      // send to HtmlRetriever Actor: sectionBaseLink (aware of CrawlerUtils Trait)
    }
  }
}
