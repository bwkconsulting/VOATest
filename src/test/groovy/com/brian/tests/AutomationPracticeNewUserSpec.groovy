package com.brian.tests

import spock.lang.Unroll

class AutomationPracticeNewUserSpec {

    String emailAddress = 'tony@maroni2.com'

    @Unroll
    def "a new user can create an account and sign in"() {
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
            enterEmailAddress(emailAddress)
        }

        and:
        Thread.sleep(3000)

        and:
        at AutomationPracticeRegistrationDetailsPage

        when:
        interact {
            enterRegistrationDetails(firstName, lastName, password, days, months, years, company, addressLineOne, addressLineTwo, city, state, postCode, country, additionalInformation, phoneNumber, mobilePhoneNumber, alias)
        }

        then:
        {
            at AutomationPracticeMyAccountPage
        }

        where:
        firstName | lastName                 | password      | days | months | years  | company      | addressLineOne      | addressLineTwo | city     | state | postCode | country | additionalInformation | phoneNumber  | mobilePhoneNumber | alias
        'Hugh'    | 'Fearnley-Whittingstall' | 'Password123' | '1'  | '1'    | '1970' | 'Prudential' | '1 Holborn Viaduct' | 'Holborn'      | 'London' | '24'  | '12345'  | '21'    | 'No mushrooms'        | '0794876435' | '0794876435'      | 'Nobby'
    }
}

