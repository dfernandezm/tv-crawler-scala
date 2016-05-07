package com.morenware.tvcrawler.actors

import akka.actor.Actor
import com.morenware.tvcrawler.crawling.CrawlerUtils
import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory

// Regular link to visit: use JSoup to visit it, get HTML
// Send HtmlSelect message to HTMLParser
case class HtmlGet(link: String, sectionName: String)

class PageRetriever extends Actor with CrawlerUtils {

  val log = Logger(LoggerFactory.getLogger("pageRetriever"))

  override def receive = {
    case HtmlGet(sectionBaseLink, sectionName) =>
      log.debug(s"PageRetriever: about to visit link $sectionBaseLink on section $sectionName")
      val doc = visitUrl(sectionBaseLink)
      log.debug(s"Html from $sectionBaseLink is ${doc.toHtml}")
    case other => log.warn(s"Unrecognized message on PageRetriever actor: $other")

  }

}

