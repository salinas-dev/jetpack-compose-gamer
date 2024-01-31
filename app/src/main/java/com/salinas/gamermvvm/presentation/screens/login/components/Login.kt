package com.salinas.gamermvvm.presentation.screens.login.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.salinas.gamermvvm.domain.model.Response
import com.salinas.gamermvvm.presentation.components.ProgressBar
import com.salinas.gamermvvm.presentation.navigation.Graph
import com.salinas.gamermvvm.presentation.screens.login.LoginViewModel

@Composable
fun Login(navController: NavController, viewModel: LoginViewModel = hiltViewModel() ){
    when(val loginResponse = viewModel.loginResponse){
        Response.Loading -> {
            ProgressBar()
        }
        is Response.Success -> {
            LaunchedEffect(Unit){
                navController.navigate(route = Graph.HOME){
                    popUpTo(Graph.AUTHENTICATION){inclusive = true}
                }
            }
            //Toast.makeText(LocalContext.current, "Usuario logeado", Toast.LENGTH_LONG).show()
        }
        is Response.Failure -> {
            //Toast.makeText(LocalContext.current, loginResponse.exception?.message ?: "Error desconocido", Toast.LENGTH_LONG).show()
        }

        else -> {}
    }
}