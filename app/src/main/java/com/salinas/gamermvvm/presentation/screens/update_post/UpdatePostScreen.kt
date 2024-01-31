package com.salinas.gamermvvm.presentation.screens.update_post

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.salinas.gamermvvm.presentation.components.DefaultButton
import com.salinas.gamermvvm.presentation.components.DefaultTopBar
import com.salinas.gamermvvm.presentation.screens.update_post.components.UpdatePost
import com.salinas.gamermvvm.presentation.screens.update_post.components.UpdatePostContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdatePostScreen(navController: NavHostController, post: String, viewModel: UpdatePostViewModel = hiltViewModel()) {

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Editar Post",
                upAvailable = true,
                navController = navController
            )
        },
        content = {
            UpdatePostContent()
        },
        bottomBar = {
            DefaultButton(
                text = "ACTUALIZAR",
                onClick = { viewModel.onUpdatePost() }
            )
        }
    )
    UpdatePost()

}