package pages

import geb.Page
import modules.HeaderModule

class LoginPage extends Page {
    static at = {title == "Sign In | ghd ® Official Website"}

    static content = {
        headerModule {module(HeaderModule)}
        emailInput {$("#login")}
        passwordInput {$("#password")}
        loginBtn {$("input[value=\"Log in\"]")}
        signupBtnConsumer(to: RegisterPage) {$(".input-button[href=\"/register/shopping\"]")}
        signupBtnProfessional {$(".input-button[href=\"/register/social\"]")}
        resendConfirmationEmailLink {$("#resend")}
    }

    void loginProcess(email, password) {
        headerModule.loginBtn.click()
        emailInput = email
        passwordInput = password
        loginBtn.click()
    }
}
