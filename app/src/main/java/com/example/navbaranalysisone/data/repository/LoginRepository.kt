package com.example.navbaranalysisone.data.repository

import com.example.navbaranalysisone.data.model.LoggedInUser
import javax.inject.Inject

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */
open class LoginRepository @Inject constructor(val dataSource: LoginDataSource) :
    LoginRepositoryInterface {

    // in-memory cache of the loggedInUser object
    override var user: LoggedInUser? = null
        set

    override val isLoggedIn: Boolean
        get() = user != null

    override fun logout() {
        user = null
        dataSource.logout()
    }


    override fun login(username: String, password: String): Result<LoggedInUser> {
        // handle login
        val result = dataSource.login(username, password)

        if (result is Result.Success) {
            setLoggedInUser(result.data)
        }

        return result
    }

    private fun setLoggedInUser(loggedInUser: LoggedInUser) {
        this.user = loggedInUser
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }
}
