import org.openqa.selenium.firefox.FirefoxDriver

baseUrl = "http://ghdhair.com/"

reportsDir = "target/geb-reports"
reportOnTestFailureOnly = true

waiting {
    timeout = 20
    retryInterval = 0.1
}

    driver = {
        System.setProperty("webdriver.gecko.driver",
            "src/test/resources/geckodriver")
        new FirefoxDriver()
    }
