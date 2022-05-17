package com.example.soapcountry.model.response.countryIntPhoneCode;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Envelope",strict = false)
public class ResponseCountryIntPhoneCodeEnvelope {
    @Element(name = "Body",required = false)
    private ResponseBody responseBody;
}
