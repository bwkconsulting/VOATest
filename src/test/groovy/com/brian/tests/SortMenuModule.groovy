package com.brian.tests
import geb.Module

class SortMenuModule extends Module {

    static content = {

        links(required: false) { $("#SortMenu > li:nth-child(4) > a:nth-child(1)") }
    }
}