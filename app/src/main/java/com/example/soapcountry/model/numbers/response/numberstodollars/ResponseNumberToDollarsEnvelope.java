package com.example.soapcountry.model.numbers.response.numberstodollars;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Envelope")
public class ResponseNumberToDollarsEnvelope {
    @Element(name = "Body")
    private ResponseNumbersToDollarsBody body;

    public ResponseNumbersToDollarsBody getBody() {
        return body;
    }
}
