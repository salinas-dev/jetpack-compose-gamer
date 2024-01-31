package com.salinas.gamermvvm.presentation.screens.posts

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.salinas.gamermvvm.presentation.screens.posts.components.DeleteLikePost
import com.salinas.gamermvvm.presentation.screens.posts.components.GetPosts
import com.salinas.gamermvvm.presentation.screens.posts.components.LikePost

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostsScreen(navController: NavHostController, viewModel: PostsViewModel = hiltViewModel()) {

    Scaffold(
        content = {
            GetPosts(navController)
        }
    )
    LikePost()
    DeleteLikePost()

}