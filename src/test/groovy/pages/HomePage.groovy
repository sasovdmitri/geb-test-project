package pages

import geb.Page
import modules.HeaderModule

class HomePage extends Page {
    static url = "/"

    static at = {title == "ghd ® Official Website | ghd Hair Straighteners | Free Next Day Delivery"}

    static content = {
        headerModule {module HeaderModule}
    }


}
