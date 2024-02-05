package com.example.navbaranalysisone.data.repository

import com.example.navbaranalysisone.data.model.LoggedInUser

interface LoginRepositoryInterface {
    var user: LoggedInUser?
    val isLoggedIn: Boolean

    fun logout()
    fun login(username: String, password: String): Result<LoggedInUser>
}
