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
public class RequestCalculatorAdd {
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
        @Element(name = "Add")
        private Add add;

        public Add getAdd() {
            return add;
        }

        public void setAdd(Add add) {
            this.add = add;
        }
    }

    @Root(name = "Add")
    @NamespaceList({
            @Namespace(reference = "http://tempuri.org/"),
    })
    public static class Add {
        @Element(name = "a")
        private Integer a;

        public Integer getA() {
            return a;
        }

        public void setA(Integer a) {
            this.a = a;
        }

        @Element(name = "b")
        private Integer b;

        public Integer getB() {
            return b;
        }

        public void setB(Integer b) {
            this.b = b;
        }
    }

}
