package com.morenware.tvcrawler.torrentdata;

/**
 * Created by david on 17/05/15.
 */
object TorrentOrigin extends Enumeration {
    type TorrentOrigin = Value
    val SEARCH, AUTOMATED_SEARCH, MANUALLY_ADDED = Value
}
