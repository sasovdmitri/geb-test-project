package pages

import geb.Page
import modules.MessageModule
import modules.ProductModule

class ProductPage extends Page {
    static at = {title == "ghd Hair Straighteners | ghd® Official"}

    static content = {
        productModule {module ProductModule}
        messageModule {module MessageModule}
    }
}
