package com.example.android.marsrealestate.uiTests

import androidx.test.espresso.Espresso.pressBack
import com.example.android.marsrealestate.screens.LaMainMenuScreen
import com.example.android.marsrealestate.utilities.BaseTest
import org.junit.Test

class LbMoreOptionTest: BaseTest() {
    @Test
    fun lbMoreOptionTest() {
        val mainMenuScreen = LaMainMenuScreen()
        mainMenuScreen.isOverflowMenuButtonVisible()

        val moreOptionsScreen = mainMenuScreen.tapOverflowMenuBtn()
            moreOptionsScreen.tapBuyButton()

        mainMenuScreen.isRecyclerViewDisplyed()
        mainMenuScreen.isOverflowMenuButtonVisible()
        mainMenuScreen.tapOverflowMenuBtn()
            moreOptionsScreen.isRentButtonDisplayed()
            moreOptionsScreen.isBuyButtonDisplayed()
            moreOptionsScreen.isShowAllButtonDisplayed()

        pressBack()

        mainMenuScreen.isRecyclerViewDisplyed()
        mainMenuScreen.isOverflowMenuButtonVisible()
    }
}