package com.brian.tests

import geb.spock.GebReportingSpec
import spock.lang.Unroll

class EbaySearchSpec extends GebReportingSpec {

    String searchItem = 'iPad'

    @Unroll
    def "a user that is not signed in can search for an item and then change search results sort order"() {
        given:
        to EbayHomePage

        and:
        interact {
            search searchItem
        }

        and:
        at SearchResultsPage

        and:
        interact {
            moveToElement(sortDropdownToggle)
        }

        and:
        waitFor { sortMenu.isDisplayed() }
        interact {
            moveToElement(sortMenu)
        }

        when:
        interact {
            sortBy(sortCriterion)
        }

        then:
        at ReorderedSearchResultsPage

        sortButtonLabelText == sortCriterion

        where:
        sortCriterion         | _
        'Lowest price + P&P'  | _
        'Highest price + P&P' | _
        'Highest price'       | _
        'Lowest price'        | _
        'Newly listed'        | _
        'Ending soonest'      | _
        'Nearest First'       | _
    }

    def "a user that is not signed in can search for an item and then filter by Auction listings"() {
        given:
        to EbayHomePage

        and:
        interact {
            search searchItem
        }

        and:
        at SearchResultsPage


        when:
        interact {
            auctionFilter.click()
        }

        then:
        at SearchResultsFilteredByAuctionPage
    }

    def "when sorted by Lowest Price Plus P&P the first listing has free postage"() {
        given:
        to EbayHomePage

        and:
        interact {
            search searchItem
        }

        and:
        at SearchResultsPage

        and:
        interact {
            moveToElement(sortDropdownToggle)
        }

        and:
        waitFor { sortMenu.isDisplayed() }
        interact {
            moveToElement(sortMenu)
        }


        when:
        interact {
            sortBy('Lowest price + P&P')
        }

        then:
        at ReorderedSearchResultsPage

        sortButtonLabelText == 'Lowest price + P&P'

        and:
        waitFor {
            shipping[0].text() == 'Free Postage'
        }
    }

    def "a user that is not signed in can search for an item and then filter by Buy it now listings"() {
        given:
        to EbayHomePage

        and:
        interact {
            search searchItem
        }

        and:
        at SearchResultsPage


        when:
        interact {

            buyItNowFilter.click()
        }

        then:
        at SearchResultsFilteredByBuyItNowPage
    }

    def "when the auction filter is applied then the first listing will have number of bids displayed"() {
        given:
        to EbayHomePage

        and:
        interact {
            search searchItem
        }

        and:
        at SearchResultsPage


        when:
        interact {
            auctionFilter.click()
        }

        then:
        at SearchResultsFilteredByAuctionPage

        numberOfBids.every { b -> b.text().matches(~/\d*\sbids?/) }
    }

    def "when the buy it now filter is applied then the first listing will have buy terms displayed"() {
        given:
        to EbayHomePage

        and:
        interact {
            search searchItem
        }

        and:
        at SearchResultsPage


        when:
        interact {
            buyItNowFilter.click()
        }

        then:
        at SearchResultsFilteredByBuyItNowPage

        buyTerms[0] == buyItNowOrBestOffer || buyItNow
    }
}