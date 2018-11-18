package modules

import geb.Module

class ProductCartRow extends Module {
    static content = {
        productCartName {$(".cart-item .productName")}
        productCartPrice {$("p.price")}
        productCartQuantity {$(".quantity-input")}
        productCartTotalPrice {$(".total .black")}
    }
}
