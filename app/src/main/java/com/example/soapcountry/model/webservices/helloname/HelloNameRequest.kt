package com.example.soapcountry.model.webservices.helloname

import org.simpleframework.xml.Element
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.NamespaceList
import org.simpleframework.xml.Root

@Root(name = "soapenv:Envelope", strict = false)
@NamespaceList(
    Namespace(prefix = "soapenv", reference = "http://schemas.xmlsoap.org/soap/envelope/")
)
class HelloNameRequest {

    @field:Element(name = "soapenv:Body", required = false)
    var body: Body? = null

    @field:Element(name = "soapenv:Header", required = false)
    var header: Header? = Header()

    @Root(name = "soapenv:Header", strict = false)
    class Header {

    }

    @Root(name = "soapenv:Body", strict = false)
    class Body {
        @field:Element(name = "HelloRequest", required = false)
        var helloRequest: HelloRequest? = null
    }

    @Root(name = "HelloRequest")
    @Namespace(reference = "http://learnwebservices.com/services/hello")
    class HelloRequest {
        @field:Element(name = "Name", required = false)
        var name: String? = null
    }
}