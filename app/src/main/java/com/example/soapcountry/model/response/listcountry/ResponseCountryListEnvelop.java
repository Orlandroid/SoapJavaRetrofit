package com.example.soapcountry.model.response.listcountry;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Envelope", strict = false)
public class ResponseCountryListEnvelop {

    @Element(name = "Body",required = false)
    private ResponseBody body;

    public ResponseBody getBody() {
        return body;
    }

    public void setBody(ResponseBody body) {
        this.body = body;
    }
}
