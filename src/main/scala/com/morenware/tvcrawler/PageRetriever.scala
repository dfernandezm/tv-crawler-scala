package com.morenware.tvcrawler

import akka.actor.Actor

// Regular link to visit: use JSoup to visit it, get HTML
// Send HtmlSelect message to HTMLParser
case class Link(link: String)

// Get HTML from resolvedLink
// Send HtmlClickThrough message with (html,selectors-1, currentResult)
case class ClickThroughLink(result: String,
                            clickThroughSelectors: String, resolvedLink: String)

//class PageRetriever extends Actor {
//  override def receive {
//
//    ???
//  }
//}

