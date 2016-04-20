package com.morenware.tvcrawler.config

import com.morenware.tvcrawler.config.ContentType._
import com.morenware.tvcrawler.config.DateType._
import com.morenware.tvcrawler.config.SectionType.SectionType
import com.morenware.tvcrawler.config.TorrentFileType._

/**
 * Created by david on 20/04/2016.
 */
class WebsiteSection (
  var name: String,
  var sectionLink: String,
  var torrentLinkType: String,
  var sectionType: String,
  var contentType: String,
  var dateStyle: String,
  var pagerParameter: String,
  var listModeParameter: String,
  var torrentDataListSelector: String,
  var headerSelector: String,
  var orderByDateParameter: String,
  var totalNumberOfElementsRegex: String,
  var totalNumberOfPagesRegex: String,
  var totalNumberOfPagesSelector: String,
  var torrentTitleSelector: String,
  var torrentLinksAndDataInSamePage: Boolean,
  var torrentFileOrMagnetLinkSelector: String,
  var dateSelector: String,
  var dateRegex: String,
  var sizeSelector: String,
  var alphabetOrderingLinkSelectors: String ) {
}
