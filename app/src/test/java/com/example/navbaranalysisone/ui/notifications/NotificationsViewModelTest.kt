package com.example.navbaranalysisone.ui.notifications

import com.example.navbaranalysisone.data.remote.ApiService
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class NotificationsViewModelTest {

    @Mock
    private lateinit var repository: ApiService

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun notificationsViewModel_isNotNull() {
        val notificationsViewModel = NotificationsViewModel(repository)
        assertNotNull(notificationsViewModel)
    }
}