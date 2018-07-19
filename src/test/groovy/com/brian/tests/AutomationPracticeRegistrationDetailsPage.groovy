package com.brian.tests

import geb.Page

class AutomationPracticeRegistrationDetailsPage extends Page {

    static at = { $(".page-heading").text() == "CREATE AN ACCOUNT" }

    static content = {
        accountCreationForm { $("#account-creation_form") }
        titleRadioMr { $("#id_gender1") }
        titleRadioMrs { $("#id_gender2") }
        firstNameTextBox { $("#customer_firstname") }
        lastNameTextBox { $("#customer_lastname") }
        email { $("#email") }
        passwordTextBox { $("#passwd") }
        daysDropDown { $("#days") }
        monthsDropDown { $("#months") }
        yearsDropDown { $("#years") }
        newsLetterCheckBox { $("#newsletter") }
        specialOffersCheckBox { $("#optin") }
        addressFirstNameTextBox { $("#firstname") }
        addressLastNameTextBox { $("#lastname") }
        addressCompanyTextBox { $("#company") }
        addressLineOneTextBox { $("#address1") }
        addressLineTwoTextBox { $("#address2") }
        addressCityTextBox { $("#city") }
        addressStateDropDown { $("#id_state") }
        addressPostCodeTextBox { $("#postcode") }
        addressCountryDropDownTextBox { $("#id_country") }
        additionalInformationPanel { $("#other") }
        phoneTextBox { $("#phone") }
        mobilePhoneTextBox { $("#phone_mobile") }
        addressAliasTextBox { $("#alias") }
        registerButton { $("#submitAccount") }
    }

    void enterRegistrationDetails(String firstName, String lastName, String password, String days, String months, String years, String company, String addressLineOne, String addressLineTwo, String city, String state, String postCode, String country, String additionalInformation, String phoneNumber, String mobilePhoneNumber, String alias) {
        titleRadioMrs.click()
        firstNameTextBox.value firstName
        lastNameTextBox.value lastName
        passwordTextBox.value password
        daysDropDown.click()
        daysDropDown.find("option").find{ it.value() == days }.click()
        monthsDropDown.click()
        monthsDropDown.find("option").find{ it.value() == months }.click()
        yearsDropDown.click()
        yearsDropDown.find("option").find{ it.value() == years }.click()
        newsLetterCheckBox.click()
        specialOffersCheckBox.click()
        addressFirstNameTextBox.value firstName
        addressLastNameTextBox.value lastName
        addressCompanyTextBox.value company
        addressLineOneTextBox.value addressLineOne
        addressLineTwoTextBox.value addressLineTwo
        addressCityTextBox.value city
        addressStateDropDown.click()
        addressStateDropDown.find("option").find{ it.value() == state }.click()
        addressPostCodeTextBox.value postCode
        addressCountryDropDownTextBox.click()
        addressCountryDropDownTextBox.find("option").find{ it.value() == country }.click()
        additionalInformationPanel.value additionalInformation
        phoneTextBox.value phoneNumber
        mobilePhoneTextBox.value mobilePhoneNumber
        addressAliasTextBox.value alias
        registerButton.click()
    }
}
