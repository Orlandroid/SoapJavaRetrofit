package com.example.soapcountry.model.calculator.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Envelope")
public class ResponseCalculatorMultiply {
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
        public MultiplyResponse getMultiplyResponse() {
            return multiplyResponse;
        }

        public void setMultiplyResponse(MultiplyResponse multiplyResponse) {
            this.multiplyResponse = multiplyResponse;
        }

        @Element(name = "MultiplyResponse")
        private MultiplyResponse multiplyResponse;
    }

    @Root(name = "MultiplyResponse")
    public static class MultiplyResponse {
        @Element(name = "MultiplyResult")
        private String multiplyResult;

        public String getMultiplyResult() {
            return multiplyResult;
        }

        public void setMultiplyResult(String multiplyResult) {
            this.multiplyResult = multiplyResult;
        }
    }
}
