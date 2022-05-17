package com.example.soapcountry.model.response.countryFlag;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Envelope",strict = false)
public class ResponseEnvelopeCountryFlag {
    @Element(name = "Body",required = false)
    private ResponseBody responseBody;

    public ResponseBody getResponseBody() {
        return responseBody;
    }
}
