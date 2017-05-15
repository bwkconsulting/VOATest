package com.brian.tests

import geb.Page

class EbayHomePage extends Page {

    static at = { title == "Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay" }

    static content = {
        searchTextBox { $("#gh-ac") }
        searchButton { $("#gh-btn") }
    }

    void search(String searchTerm) {
        searchTextBox.value searchTerm
        searchButton.click()
    }
}
