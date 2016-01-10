package com.morenware.tvcrawler.torrentdata

/**
 * Created by david on 10/01/2016.
 */
object TorrentState extends Enumeration {
  type TorrentState = Value

  val DOWNLOADING,
  DOWNLOAD_COMPLETED,
  RENAMING,
  RENAMING_COMPLETED,
  FETCHING_SUBTITLES,
  FAILED_DOWNLOAD_ATTEMPT,
  NEW,
  AWAITING_DOWNLOAD,
  COMPLETED_WITH_ERROR = Value
}