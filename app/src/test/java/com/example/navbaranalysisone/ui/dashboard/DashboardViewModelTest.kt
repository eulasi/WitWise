package com.example.navbaranalysisone.ui.dashboard

import com.example.navbaranalysisone.data.remote.ApiService
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class DashboardViewModelTest {

    @Mock
    private lateinit var repository: ApiService

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }


    @Test
    fun dashboardViewModel_isNotNull() {
        val dashboardViewModel = DashboardViewModel(repository)
        assertNotNull(dashboardViewModel)
    }
}