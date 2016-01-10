package com.morenware.tvcrawler.torrentdata

import com.morenware.tvcrawler.torrentdata.TorrentOrigin.TorrentOrigin
import com.morenware.tvcrawler.torrentdata.TorrentState.TorrentState
import com.morenware.tvcrawler.torrentdata.TorrentContentType.TorrentContentType
import org.joda.time.LocalDateTime

class TorrentResult {

  var title: String = _
  var magnetLink: String = _
  var torrentFileLink: String = _
  var size: Int = _
  var seeds: Int = _
  var siteId: String = _
  var language: String = _
  var quality: String = _

  var date: LocalDateTime = _
  var dateFound: LocalDateTime = _

  var state: TorrentState = _
  var contentType: TorrentContentType = _
  var origin: TorrentOrigin = _

}
