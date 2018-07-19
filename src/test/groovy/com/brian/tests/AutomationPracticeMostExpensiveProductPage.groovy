package com.brian.tests

import geb.Page

class AutomationPracticeMostExpensiveProductPage extends Page {
    static at = { title == "Printed Dress - My Store" }

    static content = {
        addToCartButton { $("#add_to_cart > button > span") }
        signOutButton { $(".logout") }
    }

    void addMostExpensiveToCart() {
        addToCartButton.click()
    }

    void closeCart() {
        $("#layer_cart > div.clearfix > div.layer_cart_product.col-xs-12.col-md-6 > span").click()
    }

    void signOut() {
        signOutButton.click()
    }
}

