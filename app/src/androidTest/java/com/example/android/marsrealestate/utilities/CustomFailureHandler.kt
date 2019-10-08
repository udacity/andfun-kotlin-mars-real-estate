package com.example.android.marsrealestate.utilities

import android.view.View
import androidx.test.espresso.EspressoException
import androidx.test.espresso.FailureHandler
import org.hamcrest.Matcher
import java.lang.AssertionError

class CustomFailureHandler : FailureHandler {
    override fun handle(error: Throwable, viewMatcher: Matcher<View>) {
        if (error is EspressoException || error is AssertionError) {
            error.stackTrace = Thread.currentThread().stackTrace
                .filter { it.className.startsWith("com.example.android.marsrealestate") }
                .toTypedArray()
        }
        throw error
    }
}