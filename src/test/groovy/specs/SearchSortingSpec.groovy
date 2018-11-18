package specs

import geb.spock.GebReportingSpec
import pages.HomePage
import pages.SearchResultsPage

class SearchSortingSpec extends GebReportingSpec {
    def "search results are sorted by prices descending"() {
        final String keyword = "hair"

        given: "user searches for " + keyword

        HomePage homePage = to HomePage
        homePage.headerModule.search(keyword)

        SearchResultsPage searchResultsPage = at SearchResultsPage
        searchResultsPage.productsTab.click()

        when: "sorting the results by prices descending"

        withNoAlert {searchResultsPage.sortResults(searchResultsPage.selectPriceDescending)}
        searchResultsPage.loadAllResults()

        def prices = searchResultsPage.getAllPrices()

        then: "products are sorted by prices descending"

        searchResultsPage.checkResultsSortedByPrice(prices, true)
    }
}
