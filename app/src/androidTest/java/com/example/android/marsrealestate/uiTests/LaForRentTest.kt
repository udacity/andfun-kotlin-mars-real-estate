package com.example.android.marsrealestate.uiTests

import androidx.test.filters.LargeTest
import com.example.android.marsrealestate.screens.LaMainMenuScreen
import com.example.android.marsrealestate.utilities.BaseTest
import org.junit.Test

@LargeTest
class LaForRentTest: BaseTest() {
    @Test
    fun laForRentTest() {
        val mainMenuScreen = LaMainMenuScreen()

        val moreOptionScreen = mainMenuScreen.tapOverflowMenuBtn()
            moreOptionScreen.tapRentButton()
        mainMenuScreen.isRecyclerViewDisplyed()

        val detailFragmentScreen = mainMenuScreen.yourRandomChoice()
            detailFragmentScreen.isRentEstateDisplayed()

    }


}