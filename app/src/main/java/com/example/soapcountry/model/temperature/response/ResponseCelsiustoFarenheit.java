package com.example.soapcountry.model.temperature.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Envelope")
public class ResponseCelsiustoFarenheit {

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

        @Element(name = "CelsiusToFahrenheitResponse")
        private CelsiusToFahrenheitResponse celsiusToFahrenheitResponse;

        public CelsiusToFahrenheitResponse getCelsiusToFahrenheitResponse() {
            return celsiusToFahrenheitResponse;
        }

        public void setCelsiusToFahrenheitResponse(CelsiusToFahrenheitResponse celsiusToFahrenheitResponse) {
            this.celsiusToFahrenheitResponse = celsiusToFahrenheitResponse;
        }
    }

    @Root(name = "CelsiusToFahrenheitResponse")
    public static class CelsiusToFahrenheitResponse {
        @Element(name = "CelsiusToFahrenheitResult")
        private String celsiusToFahrenheitResult;

        public String getCelsiusToFahrenheitResult() {
            return celsiusToFahrenheitResult;
        }

        public void setCelsiusToFahrenheitResult(String celsiusToFahrenheitResult) {
            this.celsiusToFahrenheitResult = celsiusToFahrenheitResult;
        }
    }

}
