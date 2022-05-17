package com.example.soapcountry.model.response.countryCurrency;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "CountryCurrencyResult",strict = false)
public class ResponseCountryCurrencyResult {
    @Element(name = "sISOCode",required = false)
    private String isoCode;

    @Element(name = "sName",required = false)
    private String sName;
}
