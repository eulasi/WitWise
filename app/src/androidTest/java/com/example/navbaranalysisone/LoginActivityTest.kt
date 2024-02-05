package com.example.navbaranalysisone

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class LoginActivityInstrumentedTest {

    @get:Rule
    val activityRule = ActivityTestRule(LoginActivity::class.java)

    // checking the behavior when the login button is clicked
    @Test
    fun loginButton_click() {
        // Type text in the username and password fields
        onView(withId(R.id.username)).perform(typeText("your_username"))
        onView(withId(R.id.password)).perform(typeText("your_password"))

        // Click the login button
        onView(withId(R.id.login)).perform(click())

    }
}
