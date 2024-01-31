package com.salinas.gamermvvm.presentation.screens.profile_edit

import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.salinas.gamermvvm.presentation.components.DefaultTopBar
import com.salinas.gamermvvm.presentation.screens.profile_edit.components.ProfileEditContent
import com.salinas.gamermvvm.presentation.screens.profile_edit.components.SaveImage
import com.salinas.gamermvvm.presentation.screens.profile_edit.components.Update


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileEditScreen(
    navController: NavHostController,
    user: String
) {
    Log.d("ProfileEditScreen", "Usuario: $user")

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Editar usuario",
                upAvailable = true,
                navController = navController
            )
        },
        content = {
            ProfileEditContent(navController = navController)
        },
        bottomBar = {}
    )
    SaveImage()
    Update()
}