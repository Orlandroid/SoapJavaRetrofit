package com.example.soapcountry.model.response.countryCurrency;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Body", strict = false)
public class ResponseBody {
    @Element(name = "CountryCurrencyResponse", required = false)
    private ResponseCountryCurrencyResponse countryCurrencyResponse;

}
