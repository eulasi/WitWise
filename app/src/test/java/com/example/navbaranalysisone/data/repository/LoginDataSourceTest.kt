package com.example.navbaranalysisone.data.repository

import org.junit.Assert.assertNotNull
import org.junit.Test

class LoginDataSourceTest {
    @Test
    fun loginDataSource_isNotNull() {
        val loginDataSource = LoginDataSource()
        assertNotNull(loginDataSource)
    }
}