package com.brian.tests

import geb.Page
import geb.spock.GebReportingSpec
import org.junit.Assert
import spock.lang.Unroll

class AutomationPracticeRegisteredUserSpec extends GebReportingSpec {

    @Unroll
    def "a registered user can sign in and add the most expensive dress to cart then sign out "() {
        given:
        to AutomationPracticeHomePage

        and:
        interact {
            signIn()
        }

        and:
        at AutomationPracticeSignInPage

        and:
        interact {
            logIn(emailAddress, password)
        }

        and:
        Thread.sleep(3000)

        and:
        at AutomationPracticeMyAccountPage

        and:
        interact {
            selectDresses()
        }

        and:
        Thread.sleep(3000)

        and:
        at AutomationPracticeDressesPage

        and:
        interact {
            sortyByMostExpensiveFirst()
        }

        and:
        Thread.sleep(5000)

        and:
        at AutomationPracticeSortedDressesPage

        and:
        interact {
//            viewMostExpensiveItem()
//            moveToElement($("#center_column > ul > li:nth-child(5) > div > div > div > a > img"))
            $("#center_column > ul > li:nth-child(5) > div > div > h5  > a").click()
        }

        and:
        Thread.sleep(5000)

        and:
        at AutomationPracticeMostExpensiveProductPage


        and:
        interact {
            addMostExpensiveToCart()
        }

        and:
        Thread.sleep(2000)

        and:
        interact {
            closeCart()
        }

        and:
        at AutomationPracticeMostExpensiveProductPage
        assert ($("div > a > span.ajax_cart_quantity").text() == "1")

        when:
        interact {
            signOut()
        }

        then:
        at AutomationPracticeSignedOutMostExpensiveProductPage

        where:
        emailAddress       | password
        'tony@maroni.com' | 'Password123'
    }

    def "an item added to the cart remains in the cart after logout and logging in again"() {
        given:
        to AutomationPracticeHomePage

        and:
        interact {
            signIn()
        }

        and:
        at AutomationPracticeSignInPage

        and:
        interact {
            logIn(emailAddress, password)
        }

        and:
        Thread.sleep(3000)

        when:
        at AutomationPracticeMyAccountPage

        then:
        assert ($("div > a > span.ajax_cart_quantity").text() == "")


        where:
        emailAddress      | password
        'tony@maroni.com' | 'Password123'
    }
}
