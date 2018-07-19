package com.brian.tests

import geb.Page
import org.junit.Assert

class AutomationPracticeSignedOutMostExpensiveProductPage extends Page {
    static at = { $(".login").text().contains("Sign in") }

//    boolean isSignedOut() {
//        if ($(".login").find { it.text() == "Sign out" }) {
//            return true
//        } else return false
//    }
}
