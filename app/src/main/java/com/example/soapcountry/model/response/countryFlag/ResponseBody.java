package com.example.soapcountry.model.response.countryFlag;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Body")
public class ResponseBody {
    @Element(name = "countryFlagResponse",required = false)
    private ResponseCountryFlagResponse responseCountryFlagResponse;

    public ResponseCountryFlagResponse getResponseCountryFlagResponse() {
        return responseCountryFlagResponse;
    }
}
