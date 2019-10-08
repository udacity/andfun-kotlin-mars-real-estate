package com.example.android.marsrealestate.uiTests

import androidx.test.filters.LargeTest
import com.example.android.marsrealestate.screens.LaMainMenuScreen
import com.example.android.marsrealestate.utilities.BaseTest
import org.junit.Test
import java.lang.Thread.*

@LargeTest
class LaSwipeRefreshTest :BaseTest() {
    @Test
    fun laForRentTest() {
        val mainMenuScreen = LaMainMenuScreen()

        val moreOptionScreen = mainMenuScreen.tapOverflowMenuBtn()
        moreOptionScreen.tapRentButton()
        mainMenuScreen.isRecyclerViewDisplyed()
//        Thread.sleep(750)
        mainMenuScreen.swipeUpScreen()
        mainMenuScreen.swipeUpScreen()
        sleep(1500)

        val detailFragmentScreen = mainMenuScreen.yourRandomChoice()
            detailFragmentScreen.isRentEstateDisplayed()

    }


}