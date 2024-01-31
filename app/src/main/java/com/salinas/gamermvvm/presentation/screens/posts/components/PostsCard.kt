package com.salinas.gamermvvm.presentation.screens.posts.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ListItemDefaults.contentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.salinas.gamermvvm.R
import com.salinas.gamermvvm.domain.model.Post
import com.salinas.gamermvvm.presentation.navigation.DetailsScreen
import com.salinas.gamermvvm.presentation.screens.posts.PostsViewModel


@Composable
fun PostsCard(navController: NavHostController, post: Post, viewModel: PostsViewModel = hiltViewModel()) {
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .padding(top = 10.dp, bottom = 10.dp)
            .clickable {
                navController.navigate(route = DetailsScreen.DetailPost.passPost(post.toJson()))
            },
    ) {
        Column {
            AsyncImage(
                model = post.image,
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(170.dp)
            )
            Text(text = post.name,
                modifier = Modifier
                    .padding(horizontal = 15.dp, vertical = 10.dp),
                fontWeight = FontWeight.Bold
            )
            Text(text = post.user?.username?: "", fontSize = 12.sp,
                modifier = Modifier
                    .padding(horizontal = 15.dp, vertical = 5.dp)
            )
            Text(text = post.description, fontSize = 12.sp, maxLines = 3, color = Color.Gray,
                modifier = Modifier
                    .padding(horizontal = 15.dp, vertical = 5.dp)
            )
            Row(
                modifier = Modifier.padding(start = 15.dp, bottom = 15.dp)
            ) {
                if (post.likes.contains(viewModel.currentUser?.uid)) {
                    Image(
                        modifier = Modifier
                            .size(23.dp)
                            .clickable {
                                viewModel.deleteLike(post.id, viewModel.currentUser?.uid ?: "")
                            },
                        painter = painterResource(id = R.drawable.like),
                        contentDescription = ""
                    )
                } else {
                    Image(
                        modifier = Modifier
                            .size(23.dp)
                            .clickable {
                                viewModel.like(post.id, viewModel.currentUser?.uid ?: "")
                            },
                        painter = painterResource(id = R.drawable.like_outline),
                        contentDescription = ""
                    )
                }

                Text(
                    modifier = Modifier.padding(start = 5.dp),
                    text = post.likes.size.toString(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )
            }
        }
    }
}
