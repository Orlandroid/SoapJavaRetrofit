package com.example.soapcountry.model.response.listcountry;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "ListOfCountryNamesByNameResult",strict = false)
public class ListOfCountryNamesByNameResult {
    @ElementList(inline = true, entry = "tCountryCodeAndName",required = false)
    private List<CountryCodeAndName> countryCodeAndName;

    public List<CountryCodeAndName> getCountryCodeAndName() {
        return countryCodeAndName;
    }
}
