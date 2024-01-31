package com.salinas.gamermvvm.presentation.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.salinas.gamermvvm.presentation.screens.login.LoginScreen
import com.salinas.gamermvvm.presentation.screens.signup.SignupScreen
import com.salinas.gamermvvm.presentation.screens.signup.SignupViewModel

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Login.route
    ) {

        composable(route = AuthScreen.Login.route) {
            LoginScreen(navController)
        }

        composable(route = AuthScreen.Signup.route) { backStackEntry ->
            // Obtén el ViewModel necesario para SignupScreen
            val viewModel: SignupViewModel = hiltViewModel(backStackEntry)
            // Pasa el NavController al ViewModel
            SignupScreen(navController, viewModel)
        }

    }
}


sealed class AuthScreen(val route: String) {

    object Login: AuthScreen("login")
    object Signup: AuthScreen("signup")

}
