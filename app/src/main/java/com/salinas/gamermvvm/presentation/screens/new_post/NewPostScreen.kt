package com.salinas.gamermvvm.presentation.screens.new_post

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.salinas.gamermvvm.presentation.components.DefaultButton
import com.salinas.gamermvvm.presentation.components.DefaultTopBar
import com.salinas.gamermvvm.presentation.screens.new_post.components.NewPost
import com.salinas.gamermvvm.presentation.screens.new_post.components.NewPostContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewPostScreen(navController: NavHostController, viewModel: NewPostViewModel = hiltViewModel()) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Nuevo Post",
                upAvailable = true,
                navController = navController
            )
        },
        content = {
            NewPostContent()
        },
        bottomBar = {
            Box(
                modifier = Modifier.padding(top = 25.dp)
            ) {
                DefaultButton(
                    text = "PUBLICAR",
                    onClick = { viewModel.onNewPost() }
                )
            }
        }
    )
    NewPost()
}
