package com.example.soapcountry.model.request.countryCurrency;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "Envelope")
@Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/" ,prefix = "soap")
public class RequestCountryCurrency {

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

        public CountryCurrency getCountryCurrency() {
            return countryCurrency;
        }

        public void setCountryCurrency(CountryCurrency countryCurrency) {
            this.countryCurrency= countryCurrency;
        }

        @Element(name = "CountryCurrency", required = false)
        private CountryCurrency countryCurrency;
    }

    @Root(name = "CountryCurrency",strict = false)
    @Namespace(reference = "http://www.oorsprong.org/websamples.countryinfo")
    public static class CountryCurrency{
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
