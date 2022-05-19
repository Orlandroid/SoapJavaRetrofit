package com.example.soapcountry.model.numbers.response.numberstowords;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Body")
public class ResponseNumbersToWordsBody {
    @Element(name = "NumberToWordsResponse")
    private NumberToWordsResponse numberToWordsResponse;

    public NumberToWordsResponse getNumberToWordsResponse() {
        return numberToWordsResponse;
    }

    public void setNumberToWordsResponse(NumberToWordsResponse numberToWordsResponse) {
        this.numberToWordsResponse = numberToWordsResponse;
    }
}
