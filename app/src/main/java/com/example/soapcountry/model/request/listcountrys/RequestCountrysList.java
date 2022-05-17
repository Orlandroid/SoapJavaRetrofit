package com.example.soapcountry.model.request.listcountrys;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;


@Root(name = "Envelope")
@Namespace(prefix = "soap12", reference = "http://www.w3.org/2003/05/soap-envelope")

public class RequestCountrysList {


    @Element(name = "soap12:Body", required = false)
    private ListaBody bBody;

    public ListaBody getbBody() {
        return bBody;
    }

    public void setbBody(ListaBody bBody) {
        this.bBody = bBody;
    }

    @Root(name = "soap12:Body", strict = false)
    public static class ListaBody {

        @Element(name = "ListOfCountryNamesByName", required = false)
        @Namespace(reference = "http://www.oorsprong.org/websamples.countryinfo")
        private ListOfCountryNamesByName listOfCountryNamesByName;

        public ListOfCountryNamesByName getListOfCountryNamesByName() {
            return listOfCountryNamesByName;
        }

        public void setListOfCountryNamesByName(ListOfCountryNamesByName listOfCountryNamesByName) {
            this.listOfCountryNamesByName = listOfCountryNamesByName;
        }

    }

    @Root(name = "ListOfCountryNamesByName")
    public static class ListOfCountryNamesByName {

    }

}
