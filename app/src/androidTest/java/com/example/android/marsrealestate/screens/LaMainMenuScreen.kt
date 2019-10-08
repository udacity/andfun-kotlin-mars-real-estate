package com.example.android.marsrealestate.screens

import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.android.marsrealestate.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher
import kotlin.random.Random

class LaMainMenuScreen {
    private val appTitle = onView(withText("Real Estate on Mars"))
    fun isAppTitleDisplayed() {
        appTitle.check(ViewAssertions.matches(withText("Real Estate on Mars")))
    }

    private val overflowMenuButton = onView(
            Matchers.allOf(
                    withContentDescription("More options"),
                    isDisplayed()))
    fun tapOverflowMenuBtn(): LbMoreOptionsScreen {
        overflowMenuButton.perform(click())
        return LbMoreOptionsScreen()
    }
    fun isOverflowMenuButtonVisible() {
        overflowMenuButton.check(ViewAssertions.matches(isFocusable()))
    }

    private val recyclerView = onView(withId(R.id.photos_grid))
    fun isRecyclerViewDisplyed() {
        recyclerView.check(ViewAssertions.matches(isDisplayed()))
//        recyclerView.perform(swipeUp())
    }
    fun swipeUpScreen() {
        recyclerView.perform(swipeUp())
    }

    internal fun yourRandomChoice(): LcDetailFragmentScreen {
        val randomInt = Random.nextInt(4) + 2
        val imageView = onView(
                Matchers.allOf(
                        withId(R.id.mars_image),
                        childAtPosition((withId(R.id.photos_grid)), randomInt),
                        isDisplayed()))
        imageView.perform(click())
        return LcDetailFragmentScreen()
    }

    // Service navigation function
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