package specs

import geb.spock.GebReportingSpec
import pages.CartPage
import pages.CheckoutPage
import pages.HomePage
import pages.ProductPage

class CheckoutPageFieldsSpec extends GebReportingSpec {

    def "All required payment fields are present on the Checkout page"() {

        given: "User adds product to cart and reaches Checkout page"

        HomePage homePage = to HomePage
        homePage.headerModule.straightenersCategory.click()

        ProductPage productPage = at ProductPage
        productPage.messageModule.footerCloseBtn.click()
        productPage.productModule.addToBasketBtn[0].click()

        CartPage cartPage = at CartPage
        cartPage.checkoutBtn.click()

        when: "Opening Payment Details on Checkout page"

        CheckoutPage checkoutPage = at CheckoutPage
        checkoutPage.paymentCheckbox = false

        then: "All the required payment fields are present"

        checkoutPage.requiredPaymentFields.forEach{
            it.displayed
        }

        checkoutPage.editBasketBtn.click()

        cartPage.deleteBtn.click()

        cartPage.emptyCartMessage.displayed
    }
}
