package com.example.navbaranalysisone.data

import com.example.navbaranalysisone.data.repository.LoginDataSource
import com.example.navbaranalysisone.data.repository.LoginRepository
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test


class LoginRepositoryTest {

    private val testLoginDataSource = LoginDataSource()
    private val loginRepository = LoginRepository(testLoginDataSource)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    // Ensuring the loginRepository behaves correctly when checking if a user is logged in
    fun isLoggedIn() {
        assertFalse(loginRepository.isLoggedIn)

        // Log in a user
        runBlocking {
            loginRepository.login("testUser", "testPassword")
        }
        assertTrue(loginRepository.isLoggedIn)

        // Log out the user
        loginRepository.logout()
        assertFalse(loginRepository.isLoggedIn)
    }

    @Test
    // Ensuring the loginRepository behaves correctly when attempting to log out
    fun logout() {
        // Log in a user
        runBlocking {
            loginRepository.login("testUser", "testPassword")
        }
        assertNotNull(loginRepository.user)

        // Log out the user
        loginRepository.logout()
        assertNull(loginRepository.user)
    }
    // checking the loginRepository.dataSource to ensure it is equal to testLoginDataSource
    @Test
    fun getDataSource() {
        assertEquals(testLoginDataSource, loginRepository.dataSource)
    }
    // checking the loginRepository to ensure it is not null
    @Test
    fun loginRepository_isNotNull() {
        val loginRepository = LoginRepository(dataSource = testLoginDataSource)
        assertNotNull(loginRepository)
    }

}
