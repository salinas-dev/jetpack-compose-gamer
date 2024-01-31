@file:OptIn(ExperimentalMaterial3Api::class)

package com.salinas.gamermvvm.presentation.screens.profile

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.salinas.gamermvvm.presentation.screens.profile.components.ProfileContent

@Composable
fun ProfileScreen(navController: NavHostController, viewModel: ProfileViewModel = hiltViewModel()) {

    Scaffold(
        topBar = {},
        content = {
            ProfileContent(navController)
        },
        bottomBar = {}
    )

}