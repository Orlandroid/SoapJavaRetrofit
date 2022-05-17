package com.example.soapcountry.model.request.countryIntPhoneCode;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;



@Root(name = "Envelope")
@Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/" ,prefix = "soap")
public class RequestCountryIntPhoneCode {

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

        public CountryIntPhoneCode getCountryIntPhoneCode() {
            return countryIntPhoneCode;
        }

        public void setCountryIntPhoneCode(CountryIntPhoneCode countryIntPhoneCode) {
            this.countryIntPhoneCode= countryIntPhoneCode;
        }

        @Element(name = "CountryIntPhoneCode", required = false)
        private CountryIntPhoneCode countryIntPhoneCode;
    }

    @Root(name = "CountryIntPhoneCode",strict = false)
    @Namespace(reference = "http://www.oorsprong.org/websamples.countryinfo")
    public static class CountryIntPhoneCode{
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

