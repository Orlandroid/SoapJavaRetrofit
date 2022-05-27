package com.example.soapcountry.model.calculator.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Envelope")
public class ResponseCalculatorDivide {
    @Element(name = "Body")
    private Body body;

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    @Root(name = "Body")
    public static class Body {
        public DivideResponse getDivideResponse() {
            return multiplyResponse;
        }

        public void setDivideResponse(DivideResponse multiplyResponse) {
            this.multiplyResponse = multiplyResponse;
        }

        @Element(name = "DivideResponse")
        private DivideResponse multiplyResponse;
    }

    @Root(name = "DivideResponse")
    public static class DivideResponse {
        @Element(name = "DivideResult")
        private String divideResult;

        public String getMultiplyResult() {
            return divideResult;
        }

        public void setMultiplyResult(String multiplyResult) {
            this.divideResult = multiplyResult;
        }
    }
}
