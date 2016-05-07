package com.morenware.tvcrawler.crawling

import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.model.Document

/**
  * Created by david on 05/05/2016.
  */
trait CrawlerUtils {
  val browser = JsoupBrowser()

  def visitUrl(url: String): Document = {
    retry(5) {
      val doc = browser.get(url)
      doc
    }
  }

  def getInitialSectionLink(baseUrl: String, baseSectionLink: String, extraParameters: String): String = {
    baseUrl + baseSectionLink + extraParameters
  }

  def getHtmlFromPage(url: String) = {
    visitUrl(url).toHtml
  }

  def retry[T](n: Int)(op: => T): T = {
    try {
      op
    } catch {
      // Catch any exception and retry the operation
      case e if n > 1 =>
        retry(n - 1)(op)
    }
  }
}
