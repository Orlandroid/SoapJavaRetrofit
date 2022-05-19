package com.example.soapcountry.model.numbers.response.numberstowords;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "NumberToWordsResponse")
public class NumberToWordsResponse {

    @Element(name = "NumberToWordsResult")
    private String numberToWordsResult;

    public String getNumberToWordsResult() {
        return numberToWordsResult;
    }

    public void setNumberToWordsResult(String numberToWordsResult) {
        this.numberToWordsResult = numberToWordsResult;
    }
}
