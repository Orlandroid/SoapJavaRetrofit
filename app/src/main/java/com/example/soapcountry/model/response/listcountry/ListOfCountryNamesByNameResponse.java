package com.example.soapcountry.model.response.listcountry;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "ListOfCountryNamesByNameResponse",strict = false)
public class ListOfCountryNamesByNameResponse {

    @Element(name = "ListOfCountryNamesByNameResult",required = false)
    private ListOfCountryNamesByNameResult listOfCountryNamesByNameResponse;

}
