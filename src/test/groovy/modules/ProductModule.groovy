package modules

import geb.Module
import pages.CartPage

class ProductModule extends Module {
    static content = {
        productName {$(".productName")}
        productPrice {$("span.price")}
        addToBasketBtn(to: CartPage) {$("input", value:"Add to Basket")}
        sendHintBtn {$(".wishlistSendHintButton")}
    }
}
