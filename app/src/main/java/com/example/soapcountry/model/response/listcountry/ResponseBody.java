package com.example.soapcountry.model.response.listcountry;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


@Root(name = "Body", strict = false)
public class ResponseBody {

    @Element(name = "ListOfCountryNamesByNameResponse",required = false)
    private ListOfCountryNamesByNameResponse listOfCountryNamesByNameResponse;
}
