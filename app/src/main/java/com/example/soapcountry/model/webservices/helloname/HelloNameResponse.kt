package com.example.soapcountry.model.webservices.helloname

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "Envelope", strict = false)
class HelloNameResponse {
    @field:Element(name = "Body", required = false)
    var body: Body? = null

    @Root(name = "Body", strict = false)
    class Body {
        @field:Element(name = "HelloResponse", required = false)
        var helloResponse: HelloResponse? = null
    }

    @Root(name = "HelloResponse", strict = false)
    class HelloResponse {
        @field:Element(name = "Message", required = false)
        var message: String? = null
    }
}
