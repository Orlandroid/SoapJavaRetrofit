package com.example.soapcountry.model.request.capitalcity;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "Envelope")
@Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/" ,prefix = "soap")
public class RequestCapitalCity {

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

        public CapitalCity getCapitalCity() {
            return capitalCity;
        }

        public void setCapitalCity(CapitalCity capitalCity) {
            this.capitalCity = capitalCity;
        }

        @Element(name = "CapitalCity", required = false)
        private CapitalCity capitalCity;
    }

    @Root(name = "CapitalCity",strict = false)
    @Namespace(reference = "http://www.oorsprong.org/websamples.countryinfo")
    public static class CapitalCity{
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
