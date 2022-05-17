package com.example.soapcountry.model.response.countryCurrency;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Envelope",strict = false)
public class ResponseCountryCurrencyEnvelope {
    @Element(name = "Body")
    private ResponseBody responseBody;
}
