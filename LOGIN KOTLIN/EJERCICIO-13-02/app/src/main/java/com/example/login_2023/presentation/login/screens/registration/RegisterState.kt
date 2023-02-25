package com.example.login_2023.presentation.login.screens.registration

import androidx.annotation.StringRes

data class RegisterState(
    val successRegister: Boolean = false,
    val displayProgressBar: Boolean = false,
    @StringRes val errorMessages: Int? = null
)
