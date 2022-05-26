package com.example.soapcountry.model.calculator.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@Root(name = "soap:Envelope")
@NamespaceList({
        @Namespace(prefix = "xsi", reference = "http://www.w3.org/2001/XMLSchema-instance"),
        @Namespace(prefix = "xsd", reference = "http://www.w3.org/2001/XMLSchema"),
        @Namespace(prefix = "soap", reference = "http://schemas.xmlsoap.org/soap/envelope/")
})
public class RequestCalculatorSubtract {

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
        @Element(name = "Subtract")
        private Subtract subtract;

        public Subtract getSubtract() {
            return subtract;
        }

        public void setSubtract(Subtract subtract) {
            this.subtract = subtract;
        }
    }

    @Root(name = "Subtract")
    @NamespaceList({
            @Namespace(reference = "http://tempuri.org/"),
    })
    public static class Subtract {
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
