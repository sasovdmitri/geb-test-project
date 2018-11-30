import geb.driver.SauceLabsDriverFactory
import org.openqa.selenium.firefox.FirefoxDriver

baseUrl = "http://ghdhair.com/"

reportsDir = "target/geb-reports"
reportOnTestFailureOnly = true

waiting {
    timeout = 20
    retryInterval = 0.1
}

def sauceLabsBrowser = System.getProperty("geb.saucelabs.browser")
if (sauceLabsBrowser) {
    driver = {
        def username = System.getenv("GEB_SAUCE_LABS_USER")
        assert username
        def accessKey = System.getenv("GEB_SAUCE_LABS_ACCESS_PASSWORD")
        assert accessKey
        new SauceLabsDriverFactory().create(sauceLabsBrowser, username, accessKey)
    }
}
else {
    driver = {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/geckodriver")
        new FirefoxDriver()
    }
}
