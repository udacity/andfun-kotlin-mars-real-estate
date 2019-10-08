package com.example.android.marsrealestate.uiTests.artifactTests


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.android.marsrealestate.MainActivity
import com.example.android.marsrealestate.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class L0_FlashTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun l0_FlashTest() {
//        val appTitle = onView(
//                allOf(
//                        withText("Real Estate on Mars"),
//                        isDisplayed()))
        val appTitle = onView(withText("Real Estate on Mars"))
        appTitle.check(matches(withText("Real Estate on Mars")))
//        Thread.sleep(1700)

        val overflowMenuButton = onView(
                allOf(withContentDescription("More options"),
//                        childAtPosition(
//                                childAtPosition(
//                                        withId(R.id.action_bar),
//                                        1),
//                                0),
                        isDisplayed()))
        overflowMenuButton.perform(click())


        val appCompatTextView = onView(
                allOf(withId(R.id.title), withText("Show all"),
//                        childAtPosition(
//                                childAtPosition(
//                                        withId(R.id.content),
//                                        0),
//                                0),
                        isDisplayed()))
        appCompatTextView.perform(click())



//        Thread.sleep(1700)

//        pressBack()
    }

    private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
