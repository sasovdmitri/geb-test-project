package modules

import geb.Browser
import geb.Module
import pages.LoginPage
import pages.ProductPage
import pages.SearchResultsPage

class HeaderModule extends Module {
    static content = {
        loginBtn(to: LoginPage) {$("#NavUserAccount")}
        cartBtn {$("#NavCartDetails")}
        searchInput {$("#search-input")}
        searchBtn(to: SearchResultsPage) {$(".searchButton")}
        newCategory {$("menu-Item1")}
        straightenersCategory(to: ProductPage) {$(".menu-Straighteners")}
        dryersCategory {$(".menu-HairDryers")}
        curlersCategory {$(".menu-Curlers")}
        productsCategory {$(".menu-HairProducts")}
        giftsCategory {$(".menu-Gifts")}
        hairstylesCategory {$(".menu-HairStyles")}
    }

    def search(String keyword) {
        searchInput << keyword
        searchBtn.click()
    }
}
