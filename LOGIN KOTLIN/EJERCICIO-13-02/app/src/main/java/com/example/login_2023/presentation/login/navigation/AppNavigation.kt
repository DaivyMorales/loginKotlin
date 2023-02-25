package com.example.login_2023.presentation.login.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.aplication_login.presentation.login.LoginScreen
import com.example.aplication_login.presentation.login.screens.HomeScreen
import com.example.aplication_login.presentation.login.screens.RegistrationScreen
import com.example.aplication_login.presentation.login.screens.login.LoginViewModel
import com.example.aplication_login.presentation.login.screens.registration.RegisterViewModel


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destinations.LoginScreen.route
    ) {
        val viewModel = LoginViewModel()
        composable(route = Destinations.LoginScreen.route) {
            if (viewModel.state.value.successLogin) {
                LaunchedEffect(key1 = Unit) {
                navController.navigate(Destinations.HomeScreen.createRoute(viewModel.state.value.email))
                    ///modificamos el historial de navegacion para no poder regresar
                    {
                        popUpTo(Destinations.LoginScreen.route) {
                            inclusive = true
                        }//fin popup
                    }//fin modificacion
                }//fin launcheffect
            } else {
                LoginScreen(
                    navController,
                    state = viewModel.state.value,
                    onLogin = viewModel::login,
                    onNavigateRegister = { navController.navigate(Destinations.RegistrationScreen.route) },
                    onNavigateForgot = { navController.navigate(Destinations.ForgotPassword.route) },
                    onDismissDialog = viewModel::hideErrorDialog
                )
            }//fin if
        }//fin composable login
        val viewModel2 = RegisterViewModel()
        composable("RegistrationScreen")
        {

            RegistrationScreen(
                navController,
                state = viewModel2.state.value,
                onRegister = viewModel2::register,
                onBack = { navController.popBackStack() },
                onDismissDialog = viewModel2::hideErrorDialog
            )
        }
        composable(
            route = Destinations.HomeScreen.route,
            arguments = listOf(navArgument("user")
            {
                type = NavType.StringType
            })
        ) {
            HomeScreen(navController = navController, user = it.arguments?.getString("user") ?: "")
        }
    }
}