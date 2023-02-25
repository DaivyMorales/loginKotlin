package com.example.login_2023.presentation.login.screens.login

import androidx.annotation.StringRes

data class LoginState(
    val email: String = "",
    val pass: String = "",
    val successLogin: Boolean = false,
    val displayProgressBar: Boolean = false,
    @StringRes val errorMessages: Int? = null
)
