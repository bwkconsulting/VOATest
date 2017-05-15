package com.brian.tests
import geb.Page

class ReorderedSearchResultsPage extends Page {

    static at = { title.startsWith("iPad | eBay") }

    static content = {
        sortDropdownToggle(required: false) { $("#DashSortByContainer > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)") }
        sortMenu(required: false) { $("#SortMenu") }
        links(required: false) { $("#SortMenu > li:nth-child(4) > a:nth-child(1)") }
        sortOrder { $("#SortMenu").text() }
        sortButtonLabelText(required: false) { $("#DashSortByContainer > ul.sel > li > a").text() }
        shipping { $("ul:nth-child(3) > li:nth-child(3) > span:nth-child(1) > span:nth-child(1) > span:nth-child(1)") }
    }
}
