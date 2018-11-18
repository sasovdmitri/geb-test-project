package specs

import geb.spock.GebReportingSpec
import pages.CartPage
import pages.CheckoutPage
import pages.HomePage
import pages.ProductPage

class CheckoutPageFieldsSpec extends GebReportingSpec {

    def "All required payments fields are present on the Checkout page"() {

        given: "user add product to cart and reaches Checkout page"

        HomePage homePage = to HomePage
        homePage.headerModule.straightenersCategory.click()

        ProductPage productPage = at ProductPage
        productPage.productModule.addToBasketBtn[0].click()

        CartPage cartPage = at CartPage
        cartPage.checkoutBtn.click()

        when: "opening Payment Details on Checkout page"

        CheckoutPage checkoutPage = at CheckoutPage
        checkoutPage.paymentCheckbox = false

        then: "all the required payment fields are present"

        checkoutPage.requiredPaymentFields.forEach{
            it.displayed
        }

        checkoutPage.editBasketBtn.click()

        cartPage.deleteBtn.click()

        cartPage.emptyCartMessage.displayed
    }
}
