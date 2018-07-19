package com.brian.tests

import geb.Page

class AutomationPracticeSignInPage extends Page {

    static at = { title == "Login - My Store" }

    static content = {
        newUserEmailTextBox { $("#email_create") }
        registeredUserEmailTextBox { $("#email") }
        passwordTextBox { $("#passwd") }
        createAnAccountButton { $("#SubmitCreate") }
        loginButton { $("#SubmitLogin") }

    }

    void enterEmailAddress(String emailAddress) {
        newUserEmailTextBox.value emailAddress
        createAnAccountButton.click()
    }

    void logIn (String emailAddress, String password) {
        registeredUserEmailTextBox.value emailAddress
        passwordTextBox.value password
        loginButton.click()
    }

    
}
