package com.example.soapcountry.model.temperature.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Envelope")
public class ResponseFarenheittoCelsius {

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

        @Element(name = "FahrenheitToCelsiusResponse")
        private FahrenheitToCelsiusResponse fahrenheitToCelsiusResponse;

        public FahrenheitToCelsiusResponse getFahrenheitToCelsiusResponse() {
            return fahrenheitToCelsiusResponse;
        }

        public void setFahrenheitToCelsiusResponse(FahrenheitToCelsiusResponse fahrenheitToCelsiusResponse) {
            this.fahrenheitToCelsiusResponse = fahrenheitToCelsiusResponse;
        }
    }

    @Root(name = "FahrenheitToCelsiusResponse")
    public static class FahrenheitToCelsiusResponse {
        @Element(name = "FahrenheitToCelsiusResult")
        private String fahrenheitToCelsiusResult;

        public String getFahrenheitToCelsiusResult() {
            return fahrenheitToCelsiusResult;
        }

        public void setFahrenheitToCelsiusResult(String fahrenheitToCelsiusResult) {
            this.fahrenheitToCelsiusResult = fahrenheitToCelsiusResult;
        }
    }

}
