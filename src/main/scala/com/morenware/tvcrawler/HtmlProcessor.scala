package com.morenware.tvcrawler

import akka.actor.Actor

// From PageRetriever
// Get Document (doc) from HTML
// Select using selector -> Get Elements
// Send each Element to DataExtractorActor along with any possible clickThroughSelectors
case class HtmlSelect(html: String, selector: String)

// Get Document from HTML
// Send Data messages to DataExtractor, which will append to currentResult
case class HtmlFromClickThrough(html: String, currentResult: String, clickThroughSelectors: String)

// From DataExtractor
// If clickThroughSelectors is not empty:
// Get the next clickThroughSelector in the list
// Use the Document to resolve a link <- resolvedLink
// Send to pageRetriever: ClickThrough(resolvedLink, currentResult, clickThroughSelectors)
// If the list is empty: save result
case class Result(result: String, doc: String, clickThroughSelectors: List[String]);

// From DataExtractor
// Same logic as Result
case class EmptyResult(doc: String, clickThroughSelectors: List[String]);

class HtmlProcessor extends Actor {
  override def receive = {
   ???
  }
}
