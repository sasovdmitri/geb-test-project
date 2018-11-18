package pages

import com.github.javafaker.Faker
import geb.Page

class RegisterPage extends Page {
    static at = {title == "Register | Account | ghd ® Official Website"}

    static content = {
        emailInput {$("#uid")}
        firstNameInput {$("#firstname")}
        surnameInput {$("#lastname")}
        maleRadiobtn {$("#gender1")}
        femaleRadiobtn {$("#gender2")}
        passwordInput {$("#password")}
        passwordConfirmInput {$("#passwordConfirmation")}
        daySelect {$("#dateOfBirth\\.day")}
        monthSelect {$("#dateOfBirth\\.month")}
        yearSelect {$("#dateOfBirth\\.year")}
        termsCheckbox {$("#termsAccepted")}
        subscribeCheckbox {$("#subscribeMe")}
        registerBtn {$("input[value=\"Register\"]")}
        alreadyRegisteredError {$("#uid\\.errors").text() == "The user already exists with this email"}
    }

    void register(email, password) {
        Faker faker = new Faker()

        emailInput = email
        firstNameInput = faker.name().firstName()
        surnameInput = faker.name().lastName()
        maleRadiobtn = true
        passwordInput = password
        passwordConfirmInput = password
        daySelect = "01"
        monthSelect = "01"
        yearSelect = "2000"
        termsCheckbox = true
        registerBtn.click()

        if (alreadyRegisteredError) {
            register(email, password)
        }
    }
}
