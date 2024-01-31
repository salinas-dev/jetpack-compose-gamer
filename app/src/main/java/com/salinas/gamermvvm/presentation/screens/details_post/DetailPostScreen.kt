package com.salinas.gamermvvm.presentation.screens.details_post

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.salinas.gamermvvm.presentation.screens.details_post.components.DetailPostContent

@Composable
fun DetailPostScreen(navController: NavHostController, post: String) {
    Scaffold(
        content = {
            DetailPostContent(navController)
        }
    )
}