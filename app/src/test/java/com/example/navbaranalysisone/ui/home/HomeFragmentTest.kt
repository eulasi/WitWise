package com.example.navbaranalysisone.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class HomeFragmentTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var viewModel: HomeViewModel
    // checking whether the API call in the HomeViewModel (viewModel.getText()) is triggered when the HomeFragment is launched
    @Test
    fun apiCallTrigger() {
        // Given
        Mockito.`when`(viewModel.getText()).thenAnswer { /* Provide the expected behavior */ }

        // When
        val scenario: FragmentScenario<HomeFragment> = launchFragmentInContainer()

        // Then
        Mockito.verify(viewModel, Mockito.times(1)).getText()
    }
}
