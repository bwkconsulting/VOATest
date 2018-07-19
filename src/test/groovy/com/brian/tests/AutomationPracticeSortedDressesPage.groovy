package com.brian.tests

import geb.Page

class AutomationPracticeSortedDressesPage extends Page {

    static at = { title == "Dresses - My Store"}

    static content = {
        sortByButton { $("#selectProductSort") }
        sortedProductList { $(".product_list row list") }
        mostExpensiveAddToCartButton { $("#add_to_cart > button > span") }
        mostExpensiveItem { $("#center_column > ul > li:nth-child(5) > div > div > h5  > a") }
    }

    void viewMostExpensiveItem() {
        moveToElement(mostExpensiveItemImage)
        mostExpensiveItem.click()
    }
}
