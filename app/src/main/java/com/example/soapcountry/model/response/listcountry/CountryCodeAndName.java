package com.example.soapcountry.model.response.listcountry;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.Comparator;

@Root(name = "tCountryCodeAndName",strict = false)
public class CountryCodeAndName {

    @Element(name = "sISOCode")
    private String sISOCode;

    @Element(name = "sName")
    private String sName;

    public static Comparator<CountryCodeAndName> SortDecending = new Comparator<CountryCodeAndName>() {
        @Override
        public int compare(CountryCodeAndName t1, CountryCodeAndName t2) {
            return t1.getsName().compareTo(t2.getsName());
        }
    };

    public Integer getTypeOfView() {
        return typeOfView;
    }

    public void setTypeOfView(Integer typeOfView) {
        this.typeOfView = typeOfView;
    }

    private Integer typeOfView=1;

    public String getsISOCode() {
        return sISOCode;
    }

    public void setsISOCode(String sISOCode) {
        this.sISOCode = sISOCode;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }
}
