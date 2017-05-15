package com.brian.tests
import geb.Page

class SearchResultsPage extends Page {

    String sortCriterion


    static at = { title.startsWith("iPad | eBay") }

    static content = {
        sortDropdownToggle(required: false) {
            $("#DashSortByContainer > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)")
        }
        sortMenu(required: false) { $("#SortMenu") }
        sortButtonLabel(required: false) { $("#SortMenu").text() }
        sortMenuOptions(required: false) { $("#SortMenu > li > a") }
        auctionFilter { $("a.small:nth-child(2)")}
        buyItNowFilter { $("a.small:nth-child(3)")}
    }

    void sortBy(String sortCriterion) {
        $(sortMenuOptions).find { it.text() == sortCriterion }.click()
    }
}

