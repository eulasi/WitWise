package com.example.navbaranalysisone.ui.notifications

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NotificationsFragmentTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    // checking the behavior of a Fragment when launched in a fragment container
    //TODO resolve this test
    @Test
    fun testFragmentInContainer() {
        // Launch the fragment in the container
        val scenario: FragmentScenario<NotificationsFragment> =
            launchFragmentInContainer()

        // Move the fragment to the RESUMED state
        scenario.moveToState(Lifecycle.State.RESUMED)

        // Assertions and interactions

        // Move the fragment to the DESTROYED state
        scenario.moveToState(Lifecycle.State.DESTROYED)
    }
}