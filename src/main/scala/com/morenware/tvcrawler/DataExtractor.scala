package com.morenware.tvcrawler

import akka.actor.Actor
import akka.actor.Actor.Receive

// use the selectors to get data
// Create torrentResult
// send Back Result message with data, context and clickSelectors
case class CreateResult(dataSelectorsList: String, docOrElement: String, clickSelectors: String)

// use the selectors to get data
// append results to torrentResult
// send Back Result message with data or EmptyResult
case class AppendResult(dataSelectorsList: String, docOrElement: String, clickSelectors: String, currentResult:String)

// Extract data passed and compose a torrent result with it
class DataExtractorActor extends Actor {
  override def receive = {
    ???
  }
}
