package com.example.soapcountry.model.numbers.response.numberstodollars;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Body")
public class ResponseNumbersToDollarsBody {
    @Element(name = "NumberToDollarsResponse")
    private NumberToDollarsResponse numberToDollarsResponse;

    public NumberToDollarsResponse getNumberToDollarsResponse() {
        return numberToDollarsResponse;
    }
}