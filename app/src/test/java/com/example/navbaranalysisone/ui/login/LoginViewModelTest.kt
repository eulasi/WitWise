package com.example.navbaranalysisone.ui.login

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.navbaranalysisone.R
import com.example.navbaranalysisone.data.repository.LoginRepository
import com.example.navbaranalysisone.data.repository.LoginRepositoryInterface
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
    lateinit var mockLoginRepository: LoginRepositoryInterface

    @Mock
    private lateinit var loginFormObserver: Observer<LoginFormState>

    @Mock
    private lateinit var loginResultObserver: Observer<LoginResult>

    @Mock
    private lateinit var loginRepository: LoginRepository

    private lateinit var loginViewModel: LoginViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

       // loginViewModel = LoginViewModel(mockLoginRepository)
        loginViewModel.loginFormState.observeForever(loginFormObserver)
        loginViewModel.loginResult.observeForever(loginResultObserver)
    }

    // this test is checking if the login data is valid
    @Test
    fun testLoginDataChanged() {
        loginViewModel.loginDataChanged("username", "password")
        verify(loginFormObserver).onChanged(LoginFormState(isDataValid = true))
    }
    // this test is checking if the login data is invalid
    @Test
    fun testLoginDataChanged_invalid() {
        loginViewModel.loginDataChanged("", "")
        verify(loginFormObserver).onChanged(LoginFormState(usernameError = R.string.invalid_username, passwordError = R.string.invalid_password))
    }

    // ensuring that when login is called with valid credentials, it triggers a change in the login result
    @Test
    fun testLogin() {
        loginViewModel.login("valid_username", "valid_password")
        verify(loginResultObserver).onChanged(LoginResult(success = LoggedInUserView(displayName = "User")))
    }

    // ensuring that when login is called with invalid credentials, it triggers a change in the login result
    @Test
    fun testLogin_invalid() {
        loginViewModel.login("", "")
        verify(loginResultObserver).onChanged(LoginResult(error = R.string.login_failed))
    }

}