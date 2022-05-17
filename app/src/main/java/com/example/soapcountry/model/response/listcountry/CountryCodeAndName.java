package com.example.soapcountry.model.response.listcountry;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "tCountryCodeAndName",strict = false)
public class CountryCodeAndName {

    @Element(name = "sISOCode")
    private String sISOCode;

    @Element(name = "sName")
    private String sName;
}
