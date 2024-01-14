package com.example.soapcountry.ui.country.adapters

fun getUrlFlag(countryCode: String): String {
    return "https://flagsapi.com/$countryCode/shiny/64.png"
}