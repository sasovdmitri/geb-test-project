package specs

import geb.spock.GebReportingSpec
import pages.HomePage
import pages.LoginPage
import pages.RegisterPage
import utils.Utils

class LoginSpec extends GebReportingSpec {
    def "New consumer user cannot login without confirming email"() {

        given: "User creates new Consumer account"

        HomePage homePage = to HomePage

        when: "User registers a new Consumer account"

        homePage.headerModule.loginBtn.click()

        LoginPage loginPage = at LoginPage
        withNoAlert {loginPage.signupBtnConsumer.click()}

        Utils utils = new Utils()
        Map credentials = utils.generateCredentials()

        RegisterPage registerPage = at RegisterPage
        registerPage.register(credentials['email'], credentials['password'])

        and: "User tries to log in"

        loginPage.loginProcess(credentials['email'], credentials['password'])

        then: "Resend Confirmation link is displayed"

        loginPage.resendConfirmationEmailLink.present
    }
}
