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
public class RequestCelsiustoFarenheit {
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
        @Element(name = "CelsiusToFahrenheit")
        private CelsiusToFahrenheit celsiusToFahrenheit;

        public CelsiusToFahrenheit getCelsiusToFahrenheit() {
            return celsiusToFahrenheit;
        }

        public void setCelsiusToFahrenheit(CelsiusToFahrenheit celsiusToFahrenheit) {
            this.celsiusToFahrenheit = celsiusToFahrenheit;
        }
    }

    @Root(name = "CelsiusToFahrenheit")
    @Namespace(reference = "https://www.w3schools.com/xml/")
    public static class CelsiusToFahrenheit {
        @Element(name = "Celsius")
        private String celsius;

        public String getCelsius() {
            return celsius;
        }

        public void setCelsius(String celsius) {
            this.celsius = celsius;
        }
    }
}
