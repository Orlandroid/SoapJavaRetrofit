package com.example.soapcountry.model.request.countryFlag;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "Envelope")
@Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/" ,prefix = "soap")
public class RequestCountryFlag {

    public Body getSoapBody() {
        return soapBody;
    }

    public void setSoapBody(Body soapBody) {
        this.soapBody = soapBody;
    }

    @Element(name = "soap:Body", required = false)
    private Body soapBody;

    @Root(name = "soap:Body",strict = false)
    public static class Body{

        public CountryFlag getCountryFlag() {
            return countryFlag;
        }

        public void setCountryFlag(CountryFlag countryFlag) {
            this.countryFlag= countryFlag;
        }

        @Element(name = "CountryFlag", required = false)
        private CountryFlag countryFlag;
    }

    @Root(name = "CountryFlag",strict = false)
    @Namespace(reference = "http://www.oorsprong.org/websamples.countryinfo")
    public static class CountryFlag{
        public String getCountryISOCode() {
            return CountryISOCode;
        }

        public void setCountryISOCode(String countryISOCode) {
            CountryISOCode = countryISOCode;
        }

        @Element(name = "sCountryISOCode", required = false)
        private String CountryISOCode;
    }


}
