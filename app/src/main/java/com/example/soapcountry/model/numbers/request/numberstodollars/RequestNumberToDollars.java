package com.example.soapcountry.model.numbers.request.numberstodollars;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "Envelope")
@Namespace(prefix = "soap", reference = "http://schemas.xmlsoap.org/soap/envelope/")
public class RequestNumberToDollars {

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
        @Element(name = "NumberToDollars")
        private NumberToDollars numberToDollars;

        public NumberToDollars getNumberToDollars() {
            return numberToDollars;
        }

        public void setNumberToDollars(NumberToDollars numberToDollars) {
            this.numberToDollars = numberToDollars;
        }
    }

    @Root(name = "NumberToDollars")
    @Namespace(reference = "http://www.dataaccess.com/webservicesserver/")
    public static class NumberToDollars {
        @Element(name = "dNum")
        private String dNum;

        public String getdNum() {
            return dNum;
        }

        public void setdNum(String dNum) {
            this.dNum = dNum;
        }
    }

}
