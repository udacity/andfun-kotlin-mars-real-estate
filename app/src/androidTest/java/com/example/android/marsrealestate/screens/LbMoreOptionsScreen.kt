package com.example.android.marsrealestate.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.android.marsrealestate.R
import org.hamcrest.Matchers

class LbMoreOptionsScreen {
    private val showAllButton = onView(
            Matchers.allOf(
                    withId(R.id.title),
                    withText("Show all"),
                    isDisplayed()))
    fun isShowAllButtonDisplayed() {
        showAllButton.check(matches(isDisplayed()))
    }
    fun tapShowAllButton(): LaMainMenuScreen {
        showAllButton.perform(click())
        return LaMainMenuScreen()
    }

    // functionality on RENT choice
    private val rentButton = onView(
            Matchers.allOf(
                    withId(R.id.title),
                    withText("Rent"),
                    isDisplayed()))

    fun isRentButtonDisplayed() {
        rentButton.check(matches(isDisplayed()))
    }
    fun tapRentButton(): LaMainMenuScreen {
        rentButton.perform(click())
        return LaMainMenuScreen()
    }

    // functionality on BUY-SALE choice
    private val buyButton = onView(
            Matchers.allOf(
                    withId(R.id.title),
                    withText("Buy"),
                    isDisplayed()))
    fun isBuyButtonDisplayed() {
        buyButton.check(matches(isDisplayed()))
    }
    fun tapBuyButton(): LaMainMenuScreen {
        buyButton.perform(click())
        return LaMainMenuScreen()
    }




}