package com.example.android.marsrealestate.uiTests
import androidx.test.filters.LargeTest
import com.example.android.marsrealestate.screens.LaMainMenuScreen
import com.example.android.marsrealestate.utilities.BaseTest
import org.junit.Test

@LargeTest
class LaFlashTest: BaseTest() {

    @Test
    fun l0_FlashTest() {
        val mainMenuScreen  = LaMainMenuScreen()

            mainMenuScreen.isAppTitleDisplayed()

        val moreOptionScreen = mainMenuScreen.tapOverflowMenuBtn()

            moreOptionScreen.tapShowAllButton()

        mainMenuScreen.isAppTitleDisplayed()
    }
}
