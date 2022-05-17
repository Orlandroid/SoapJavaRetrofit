package com.example.soapcountry.model.response.capitalcity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "CapitalCityResponse")
public class CapitalResult {

    @Element(name = "CapitalCityResult")
    private String capitalCityResult;

    public String getCapitalCityResult() {
        return capitalCityResult;
    }
}
