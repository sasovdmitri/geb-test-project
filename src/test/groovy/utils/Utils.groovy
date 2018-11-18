package utils

import com.github.javafaker.service.FakeValuesService
import com.github.javafaker.service.RandomService
import geb.Browser

class Utils extends Browser {

    Map generateCredentials () {
        FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService())

        Map credentials = [:]
        credentials['email'] = fakeValuesService.bothify("?????#####?????@gma1l.com")
        credentials['password'] = fakeValuesService.bothify("?????#####?????")

        return credentials
    }

    String selectRandom(element) {
        def number = Math.abs(new Random().nextInt() % 10 + 1)
        return element.$("option", number).@value
    }
}
