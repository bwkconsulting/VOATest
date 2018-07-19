package com.brian.tests

import geb.Page

class AutomationPracticeMyAccountPage extends Page {

    static at = { title == "My account - My Store" }

    static content = {
        dressesButton { $("#block_top_menu > ul > li:nth-child(2)") }
    }

    void selectDresses() {
        dressesButton.click()
    }
}
