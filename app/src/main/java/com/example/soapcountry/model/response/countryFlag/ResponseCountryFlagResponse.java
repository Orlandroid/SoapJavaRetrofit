package com.example.soapcountry.model.response.countryFlag;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "CountryFlagResponse",strict = false)
public class ResponseCountryFlagResponse {
    @Element(name = "CountryFlagResult",required = false)
    private String countryFlagResultUrl;
}
