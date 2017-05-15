package com.brian.tests
import geb.Page

class SearchResultsFilteredByBuyItNowPage extends Page {

    static at = { $("span.small").text() == 'Buy it now' }

    static content = {
        listing { $("ul#ListViewInner > li")}
        buyTerms { $( 'ul:nth-child(4) > li:nth-child(2) > span:nth-child(1) > span:nth-child(1)')}
        buyItNowOrBestOffer { $('[title="Buy it now or Best Offer"]') }
        buyItNow { $('[title="Buy it now"]') }
    }
}
