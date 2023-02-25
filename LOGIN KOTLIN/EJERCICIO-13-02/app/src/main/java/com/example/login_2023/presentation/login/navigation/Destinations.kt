package com.example.login_2023.presentation.login.navigation

sealed class Destinations(
    val route : String
) {
    object LoginScreen : Destinations(route = "LoginScreen/{nameValue}") {
        fun crearRouteNueva(nameValue : String) : String {
            return "LoginScreen/$nameValue"
        }
    }
    object RegistrationScreen : Destinations(route = "RegistrationScreen")
    object ForgotPassword : Destinations(route = "ForgotPassword")
    object HomeScreen : Destinations("HomeScreen/{user}") {
        fun createRoute(user: String): String {
            return "HomeScreen/$user"
        }
    }
}

