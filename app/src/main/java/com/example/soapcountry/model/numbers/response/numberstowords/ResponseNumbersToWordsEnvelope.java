package com.example.soapcountry.model.numbers.response.numberstowords;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Envelope")
public class ResponseNumbersToWordsEnvelope {
    @Element(name = "Body")
    private ResponseNumbersToWordsBody responseNumbersToWordsBody;

    public ResponseNumbersToWordsBody getResponseNumbersToWordsBody() {
        return responseNumbersToWordsBody;
    }

    public void setResponseNumbersToWordsBody(ResponseNumbersToWordsBody responseNumbersToWordsBody) {
        this.responseNumbersToWordsBody = responseNumbersToWordsBody;
    }
}
