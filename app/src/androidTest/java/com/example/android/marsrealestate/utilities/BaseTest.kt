package com.example.android.marsrealestate.utilities

import androidx.test.rule.ActivityTestRule
import com.example.android.marsrealestate.MainActivity
import org.junit.Rule

//@LargeTest
//@RunWith(AndroidJUnit4::class)

open class BaseTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

}