package com.brian.tests

import geb.Page


class AutomationPracticeDressesPage extends Page {

    static at = { title == "Dresses - My Store"}

    static content = {
        sortByButton { $("#selectProductSort") }
        sortedProductList { $(".product_list row list") }
        mostExpensiveAddToCartButton {
            $("#center_column > ul > li:nth-child(5) > div > div > div:nth-child(4) > :nth-child(1) > span")
        }
    }

    void sortyByMostExpensiveFirst() {
        sortByButton.click()
        sortByButton.find("option").find{ it.value() == "price:desc" }.click()
    }
}
