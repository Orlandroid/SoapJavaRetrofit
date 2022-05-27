package com.example.soapcountry.model.calculator.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@Root(name = "soap:Envelope")
@NamespaceList({
        @Namespace(prefix = "xsi", reference = "http://www.w3.org/2001/XMLSchema-instance"),
        @Namespace(prefix = "xsd", reference = "http://www.w3.org/2001/XMLSchema"),
        @Namespace(prefix = "soap", reference = "http://schemas.xmlsoap.org/soap/envelope/"),
})
public class RequestCalculatorDivide {
    @Element(name = "soap:Body")
    private Body body;

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    @Root(name = "soap:Body")
    public static class Body {
        public Divide getDivide() {
            return multiply;
        }

        public void setDivide(Divide multiply) {
            this.multiply = multiply;
        }

        @Element(name = "Divide")
        private Divide multiply;
    }

    @Root(name = "Divide")
    @Namespace(reference = "http://tempuri.org/")
    public static class Divide {

        @Element(name = "intA")
        private Integer a;
        @Element(name = "intB")
        private Integer b;

        public Integer getA() {
            return a;
        }

        public void setA(Integer a) {
            this.a = a;
        }

        public Integer getB() {
            return b;
        }

        public void setB(Integer b) {
            this.b = b;
        }

    }

}
