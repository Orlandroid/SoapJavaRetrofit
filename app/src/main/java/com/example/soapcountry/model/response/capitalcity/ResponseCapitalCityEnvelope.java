package com.example.soapcountry.model.response.capitalcity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Envelope",strict = false)
public class ResponseCapitalCityEnvelope {
    @Element(name = "Body")
    private CapitalCityResponse responseBody;
}
