package com.morenware.tvcrawler

import akka.actor.{Actor, ActorSystem, Props}
import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL.Parse._
import net.ruippeixotog.scalascraper.model.{ElementQuery, Element}
import org.jsoup.Connection


case class BaseLink(link: String)

class HelloActor extends Actor {
  def receive = {
    case "hello" => println("hello back at you")
    case _       => println("huh?")
  }
}

class PageLoader extends Actor {
  def receive = {
    case BaseLink(link) =>  {
      println("Received link " + link)

      val browser = JsoupBrowser()
      val doc = browser.get(link)

      // Extract the text inside the first h1 element
      val title: String = doc >> text("h1")
      println("Title " +  title)

      // Extract the elements with class "item"
      //val items: List[Element] = doc >> elementList(".item")

      // From each item, extract the text of the h3 element inside
      //val itemTitles: List[String] = items.map(_ >> text("h3"))

      // From the meta element with "viewport" as its attribute name, extract the
      // text in the content attribute
      //val viewport: String = doc >> attr("content")("meta[name=viewport]")

    }
  }
}

//object Main extends App {
//  val system = ActorSystem("HelloSystem")
//  // default Actor constructor
//  val helloActor = system.actorOf(Props[HelloActor], name = "helloactor")
//  helloActor ! "hello"
//  helloActor ! "buenos dias"
//
//  val pageLoader = system.actorOf(Props[PageLoader], name = "pageLoader")
//
//  pageLoader ! BaseLink("http://www.divxtotal.com/series/")
//}

