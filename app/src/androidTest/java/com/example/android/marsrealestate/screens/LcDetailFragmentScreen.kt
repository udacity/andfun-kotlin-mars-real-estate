package com.example.android.marsrealestate.screens

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.example.android.marsrealestate.R
import org.hamcrest.Matchers

class LcDetailFragmentScreen {
    private val appTitle = Espresso.onView(ViewMatchers.withText("Real Estate on Mars"))
    fun isAppTitleDisplayed() {
        appTitle.check(ViewAssertions.matches(ViewMatchers.withText("Real Estate on Mars")))
    }

    val saleEstate = Espresso.onView(ViewMatchers.withText("For Sale"))
    fun isSaleEstateDisplayed() {
        saleEstate.check(matches(isDisplayed()))
    }

    val rentEstate = Espresso.onView(ViewMatchers.withText("For Rent"))
    fun isRentEstateDisplayed() {
        rentEstate.check(matches(isDisplayed()))
    }

    val anyEstate = Espresso.onView(ViewMatchers.withId(R.id.property_type_text))
    fun isAnyEstateDisplayed() {
        anyEstate.check(matches(isDisplayed()))
    }

}