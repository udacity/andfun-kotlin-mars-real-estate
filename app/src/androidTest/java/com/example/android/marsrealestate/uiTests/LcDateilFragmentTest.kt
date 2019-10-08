package com.example.android.marsrealestate.uiTests

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.*
import androidx.test.filters.LargeTest
import com.example.android.marsrealestate.screens.LaMainMenuScreen
import com.example.android.marsrealestate.utilities.BaseTest
import org.junit.Test
@LargeTest
class LcDateilFragmentTest: BaseTest() {
    @Test
    fun lcDateFragmentTest(){
        val mainMenuScreen = LaMainMenuScreen()
        Thread.sleep(250)

        val detailFragmentScreen = mainMenuScreen.yourRandomChoice()

        detailFragmentScreen.isAnyEstateDisplayed()

        pressBack()

        mainMenuScreen.isRecyclerViewDisplyed()

    }
}