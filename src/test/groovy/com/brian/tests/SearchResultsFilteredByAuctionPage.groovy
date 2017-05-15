package com.brian.tests
import geb.Page

class SearchResultsFilteredByAuctionPage extends Page {

    static at = { $("span.small").text() == 'Auction' }

    static content = {
        firstListing { $("ul#ListViewInner > li:nth-child(2)") }
        listing { $("ul#ListViewInner > li")}
        shipping { $("ul:nth-child(3) > li:nth-child(3) > span:nth-child(1) > span:nth-child(1) > span:nth-child(1)") }
        numberOfBids { $("ul:nth-child(4) > li:nth-child(2) > span:nth-child(1)") }
    }
}

