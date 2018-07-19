package com.brian.tests

import geb.Page


class AutomationPracticeHomePage extends Page {

    static at = { title == "My Store" }

    static content = {
        loginButton { $(".login") }
    }

    void signIn() {
        loginButton.click()
    }
}
