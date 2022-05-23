package com.example.soapcountry.model.calculator.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Envelope")
public class ResponseCalculatorAdd {
    @Element(name = "Body")
    private Body body;

    public Body getBody() {
        return body;
    }

    @Root(name = "Body")
    public static class Body {
        @Element(name = "AddResponse")
        private AddResponse addResponse;

        public AddResponse getAddResponse() {
            return addResponse;
        }
    }


    @Root(name = "AddResponse")
    public static class AddResponse {
        @Element(name = "AddResult")
        private String addResult;

        public String getAddResult() {
            return addResult;
        }
    }

}


