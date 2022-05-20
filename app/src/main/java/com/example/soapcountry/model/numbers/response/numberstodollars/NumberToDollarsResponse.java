package com.example.soapcountry.model.numbers.response.numberstodollars;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "NumberToDollarsResponse")
public class NumberToDollarsResponse {
    @Element(name = "NumberToDollarsResult")
    private String numberToDollarsResult;

    public String getNumberToDollarsResult() {
        return numberToDollarsResult;
    }
}
