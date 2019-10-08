package com.example.android.marsrealestate.uiTests

import androidx.test.filters.LargeTest
import com.example.android.marsrealestate.screens.LaMainMenuScreen
import com.example.android.marsrealestate.utilities.BaseTest
import org.junit.Test

@LargeTest
class LaForSaleTest: BaseTest() {
    @Test
    fun la_ForSaleTest() {
        val mainMenuScreen  = LaMainMenuScreen()

        val moreOptionScreen = mainMenuScreen.tapOverflowMenuBtn()

            moreOptionScreen.tapBuyButton()

        mainMenuScreen.isRecyclerViewDisplyed()

        Thread.sleep(50)

        val detailFragmentScreen = mainMenuScreen.yourRandomChoice()

            detailFragmentScreen.isSaleEstateDisplayed()


    }

}