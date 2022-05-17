package com.example.soapcountry.model.response.capitalcity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Body", strict = false)
public class CapitalCityResponse {
    @Element(name = "CapitalCityResponse")
    private CapitalResult capitalCityResult;
}
