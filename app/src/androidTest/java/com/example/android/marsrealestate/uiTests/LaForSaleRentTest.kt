package com.example.android.marsrealestate.uiTests

import androidx.test.espresso.Espresso.pressBack
import com.example.android.marsrealestate.screens.LaMainMenuScreen
import com.example.android.marsrealestate.utilities.BaseTest
import org.junit.Test

class LaForSaleRentTest:BaseTest() {
    @Test
    fun laForRentTest() {
        val mainMenuScreen = LaMainMenuScreen()

        val moreOptionScreen = mainMenuScreen.tapOverflowMenuBtn()
        moreOptionScreen.tapRentButton()

        val detailFragmentScreen = mainMenuScreen.yourRandomChoice()
        detailFragmentScreen.isRentEstateDisplayed()

        pressBack()

        mainMenuScreen.tapOverflowMenuBtn()

        moreOptionScreen.tapBuyButton()

        mainMenuScreen.yourRandomChoice()

        detailFragmentScreen.isSaleEstateDisplayed()

    }

}