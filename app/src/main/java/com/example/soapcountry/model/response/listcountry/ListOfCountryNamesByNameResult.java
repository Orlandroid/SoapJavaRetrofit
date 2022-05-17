package com.example.soapcountry.model.response.listcountry;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "ListOfCountryNamesByNameResult",strict = false)
public class ListOfCountryNamesByNameResult {
    @Element(name = "tCountryCodeAndName",required = false)
    private CountryCodeAndName countryCodeAndName;
}
