package pages

import geb.Page
import modules.HeaderModule
import modules.ProductModule

class SearchResultsPage extends Page {
    static url = "search"

    static at = {title == "Search ghdhair.com | ghd ® Official Website"}

    static content = {
        headerModule {module HeaderModule}
        productModule {module ProductModule}

        allTab {$("#tabItem-all")}
        productsTab (to: SearchResultsPage) {$("#tabItem-products")}
        postsTab {$("#tabItem-posts")}
        articlesTab {$("#tabItem-articles")}
        profilesTab {$("#tabItem-profiles")}
        otherTab {$("#tabItem-other")}

        sortSelect {$("#searchOrder")}
        selectRelevance {$("option[value=\"score\"]")}
        selectPriceDescending {$("option[value=\"price-descending\"]")}
        selectPriceAscending {$("option[value=\"price-ascending\"]")}
        selectRating {$("option[value=\"bv-rating\"]")}
        productsTabCount {productsTab.find("em.helvetica")}
        searchResultsCount {$(".salutation strong", 0)}
        searchResultsKeyword {$(".salutation strong", 1)}
    }

    void checkSearchResults(String keyword) {
        searchResultsKeyword.text() == "\"" + keyword.toUpperCase() + "\""
        searchResultsCount.text().toInteger() > 0
    }

    void sortResults(sortingMethod) {
        sortSelect = sortingMethod.value()
    }

    void loadAllResults() {
        def productsCount = productsTabCount.text() as Integer

        while (productModule.productPrice.size() < productsCount) {
            def productsNumberDisplayed = productModule.productPrice.size() - 1
            js.exec('$("span.price")[' + productsNumberDisplayed + '].scrollIntoView();')
        }
    }

    ArrayList<Float> getAllPrices() {
        def prices =  productModule.productPrice*.text()
        return prices*.substring(1)*.asType(float)
    }

    void checkResultsSortedByPrice(prices, descending) {
        if (descending) {
            prices == prices.toSorted().reverse()
        } else {
            prices == prices.toSorted()
        }
    }
}
