package com.example.navbaranalysisone.ui.login

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.navbaranalysisone.R
import com.example.navbaranalysisone.data.repository.LoginRepository
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LoginViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @get:Rule
    val mockitoRule = MockitoJUnit.rule()

    @Mock
    lateinit var mockLoginRepository: LoginRepository

    @Mock
    private lateinit var loginFormObserver: Observer<LoginFormState>

    @Mock
    private lateinit var loginResultObserver: Observer<LoginResult>

    @Mock
    private lateinit var loginRepository: LoginRepository

    private lateinit var loginViewModel: LoginViewModel

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)

        loginViewModel = LoginViewModel(mockLoginRepository)
        loginViewModel.loginFormState.observeForever(loginFormObserver)
        loginViewModel.loginResult.observeForever(loginResultObserver)
    }

    // this test is checking if the login data is valid
    @Test
    fun testLoginDataChanged() {
        loginViewModel.loginDataChanged("username", "password")
        verify(loginFormObserver).onChanged(LoginFormState(isDataValid = true))
    }

    // ensuring that when login is called with invalid credentials, it triggers a change in the login result
    @Test
    fun testLogin_invalid() {
        loginViewModel.login("", "")
        verify(loginResultObserver).onChanged(LoginResult(error = R.string.login_failed))
    }
    // ensure View model is not null
    @Test
    fun loginViewModel_isNotNull() {
        val loginViewModel = LoginViewModel(loginRepository)
        assertNotNull(loginViewModel)
    }

    @Test
    fun testLogin() {
        val loginViewModel = LoginViewModel(loginRepository)
        loginViewModel.login("valid_username", "valid_password")
        // Verify that loginRepository.login is called with the correct arguments
        verify(loginRepository).login("valid_username", "valid_password")
    }
}