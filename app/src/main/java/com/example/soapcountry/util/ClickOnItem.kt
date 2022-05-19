package com.example.soapcountry.util

interface ClickOnItem<T> {
    fun clickOnElement(element: T, position: Int? = null)
}