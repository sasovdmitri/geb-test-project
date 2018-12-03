package specs

import geb.spock.GebReportingSpec
import pages.HomePage
import pages.SearchResultsPage

class SearchSortingSpec extends GebReportingSpec {
    def "search results are sorted by prices descending"() {
        final String keyword = "hair"

        given: "User searches for " + keyword

        HomePage homePage = to HomePage
        homePage.headerModule.search(keyword)

        SearchResultsPage searchResultsPage = at SearchResultsPage
        searchResultsPage.productsTab.click()

        when: "Sorting the results by prices descending"

        withNoAlert {searchResultsPage.sortResults(searchResultsPage.selectPriceDescending)}
        searchResultsPage.loadAllResults()

        def prices = searchResultsPage.getAllPrices()

        then: "Products are sorted by prices descending"

        searchResultsPage.checkResultsSortedByPrice(prices, true)
    }
}
