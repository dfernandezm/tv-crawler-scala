package com.morenware.tvcrawler.config

/**
 * Created by david on 20/04/2016.
 */
class CrawlerConfig(
                     var name: String,
                     var siteId: String,
                     var baseUrl: String,
                     var language: String,
                     var sections: List[WebsiteSection]) {

}
