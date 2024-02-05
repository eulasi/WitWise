package com.example.navbaranalysisone.data

import com.example.navbaranalysisone.data.repository.LoginDataSource
import com.example.navbaranalysisone.data.repository.LoginRepository
import com.example.navbaranalysisone.data.repository.Result
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

// TODO : Fix this test
    @Test
    // Ensuring the loginRepository behaves correctly when attempting to log in with both valid and invalid credentials
    fun login() = runBlocking {
        // Act
        val result = loginRepository.login("testUser", "testPassword")
        val failedResult = loginRepository.login("invalidUser", "invalidPassword")
        // Assert
        assertTrue(result is Result.Success<*>)
        assertNotNull(loginRepository.user)
        assertEquals("User", loginRepository.user?.displayName)
        assertTrue(failedResult is Result.Error)
        assertNull(loginRepository.user)
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
}
