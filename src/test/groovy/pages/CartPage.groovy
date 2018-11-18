package pages

import geb.Page
import modules.ProductCartRow

class CartPage extends Page {
    static at = {title == "My Basket | Basket | ghd ® Official Website"}

    static content = {
        deleteBtn {$("input[value=\"Delete\"]")}
        checkoutBtn (to: CheckoutPage) {$("#cartCheckoutBtn")}
        emptyCartMessage {$(".cartEmpty")}

        productListTable {$("ul#cart-items").moduleList(ProductCartRow)}
    }
}
