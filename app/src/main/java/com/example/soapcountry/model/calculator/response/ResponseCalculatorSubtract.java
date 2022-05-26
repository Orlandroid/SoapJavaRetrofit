package com.example.soapcountry.model.calculator.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Envelope")
public class ResponseCalculatorSubtract {

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
        public SubtractResponse getSubtractResponse() {
            return subtractResponse;
        }

        public void setSubtractResponse(SubtractResponse subtractResponse) {
            this.subtractResponse = subtractResponse;
        }

        @Element(name = "SubtractResponse")
        private SubtractResponse subtractResponse;
    }

    @Root(name = "SubtractResponse")
    public static class SubtractResponse {
        @Element(name = "SubtractResult")
        private String subtractResult;

        public String getSubtractResult() {
            return subtractResult;
        }

        public void setSubtractResult(String subtractResult) {
            this.subtractResult = subtractResult;
        }
    }
}
