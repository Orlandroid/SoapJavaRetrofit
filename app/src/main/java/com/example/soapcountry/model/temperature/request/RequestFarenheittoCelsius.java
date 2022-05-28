package com.example.soapcountry.model.temperature.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@Root(name = "soap12:Envelope")
@NamespaceList({
        @Namespace(prefix = "xsi", reference = "http://www.w3.org/2001/XMLSchema-instance"),
        @Namespace(prefix = "xsd", reference = "http://www.w3.org/2001/XMLSchema"),
        @Namespace(prefix = "soap12", reference = "http://www.w3.org/2003/05/soap-envelope"),
})
public class RequestFarenheittoCelsius {
    @Element(name = "soap12:Body")
    private Body body;

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    @Root(name = "soap12:Body")
    public static class Body {
        @Element(name = "FahrenheitToCelsius")
        private FahrenheitToCelsius fahrenheitToCelsius;

        public FahrenheitToCelsius getFahrenheitToCelsius() {
            return fahrenheitToCelsius;
        }

        public void setFahrenheitToCelsius(FahrenheitToCelsius celsiusToFahrenheit) {
            this.fahrenheitToCelsius = celsiusToFahrenheit;
        }
    }

    @Root(name = "FahrenheitToCelsius")
    @Namespace(reference = "https://www.w3schools.com/xml/")
    public static class FahrenheitToCelsius {
        @Element(name = "Fahrenheit")
        private Integer fahrenheit;

        public Integer getfahrenheit() {
            return fahrenheit;
        }

        public void setfahrenheit(Integer fahrenheit) {
            this.fahrenheit = fahrenheit;
        }
    }
}
