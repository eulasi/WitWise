package com.example.navbaranalysisone.ui.home

import com.example.navbaranalysisone.data.remote.ApiService
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class HomeViewModelTest {

    @Mock
    private lateinit var repository: ApiService

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun homeViewModel_isNotNull() {
        val homeViewModel = HomeViewModel(repository)
        assertNotNull(homeViewModel)
    }
}