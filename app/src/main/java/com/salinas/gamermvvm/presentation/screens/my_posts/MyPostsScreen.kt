package com.salinas.gamermvvm.presentation.screens.my_posts

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.salinas.gamermvvm.presentation.navigation.DetailsScreen
import com.salinas.gamermvvm.presentation.screens.my_posts.components.GetPostsByIdUser

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyPostsScreen(navController: NavHostController){
    Scaffold(
        content = {
            GetPostsByIdUser(navController = navController)
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(bottom = 50.dp),
                onClick = { navController.navigate(DetailsScreen.NewPost.route) },
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = ""
                )
            }
        }
    )
}