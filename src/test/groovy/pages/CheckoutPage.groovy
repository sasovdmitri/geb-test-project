package pages

import geb.Page

class CheckoutPage extends Page {
    static at = {title == "Your Details | Checkout| ghd ® Official Website"}

    static content = {
        editBasketBtn (to: CartPage) {$("#cartDetails .editbasket")}
        paymentCheckbox {$("#paymentSameAsDelivery")}
        firstNameInput {$("#paymentAddress\\.firstname")}
        lastNameInput {$("#paymentAddress\\.lastname")}
        countrySelect {$("#paymentAddress\\.country")}
        postcodeInput {$("#paymentAddress\\.postalcode")}
        addressLine1Input {$("#paymentAddress\\.addressLine1")}
        townInput {$("#paymentAddress\\.town")}
        paymentAddressContainer {$("#paymentAddressContainer")}
        requiredPaymentFields {$("#paymentAddressContainer label span.required")}
    }
}
