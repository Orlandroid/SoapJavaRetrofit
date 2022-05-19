package com.example.soapcountry.model.numbers.request.numberstowords;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "Envelope")
@Namespace(prefix = "soap", reference = "http://schemas.xmlsoap.org/soap/envelope/")
public class RequestNumbersToWords {

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
        @Element(name = "NumberToWords")
        private NumberToWords numberToWords;

        public NumberToWords getNumberToWordsResponse() {
            return numberToWords;
        }

        public void setNumberToWordsResponse(NumberToWords numberToWordsResponse) {
            this.numberToWords = numberToWordsResponse;
        }
    }

    @Root(name = "NumberToWords")
    @Namespace(reference = "http://www.dataaccess.com/webservicesserver/")
    public static class NumberToWords {
        @Element(name = "ubiNum")
        private String ubiNum;

        public String getUbiNum() {
            return ubiNum;
        }

        public void setUbiNum(String ubiNum) {
            this.ubiNum = ubiNum;
        }
    }

}
