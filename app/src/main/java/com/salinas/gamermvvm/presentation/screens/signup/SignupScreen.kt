package com.salinas.gamermvvm.presentation.screens.signup

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.salinas.gamermvvm.presentation.components.DefaultTopBar
import com.salinas.gamermvvm.presentation.screens.signup.components.SignUp
import com.salinas.gamermvvm.presentation.screens.signup.components.SignupContent
import com.salinas.gamermvvm.presentation.ui.theme.GamerMVVMTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(navController: NavHostController, viewModel: SignupViewModel) {

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Nuevo usuario",
                upAvailable = true,
                navController = navController
            )
        },
        content = {
            SignupContent(navController)
        },
        bottomBar = {}
    )
    SignUp(navController = navController)

}
