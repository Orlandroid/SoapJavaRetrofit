package com.example.soapcountry.model.response.listcountry;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Envelope", strict = false)
public class ResponseCountryListEnvelop {

    @Element(name = "Body")
    private ResponseCountryListBody body;

    public ResponseCountryListBody getBody() {
        return body;
    }

    public void setBody(ResponseCountryListBody body) {
        this.body = body;
    }
}
