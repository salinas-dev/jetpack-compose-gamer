package com.salinas.gamermvvm.presentation.screens.profile.components

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.salinas.gamermvvm.R
import com.salinas.gamermvvm.presentation.MainActivity
import com.salinas.gamermvvm.presentation.components.DefaultButton
import com.salinas.gamermvvm.presentation.navigation.DetailsScreen
import com.salinas.gamermvvm.presentation.screens.profile.ProfileViewModel

@Composable
fun ProfileContent(navController: NavHostController, viewModel: ProfileViewModel = hiltViewModel()) {

    val activity = LocalContext.current as? Activity

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box() {

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                painter = painterResource(id = R.drawable.background),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                alpha = 0.6f
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "Bienvenido",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(55.dp))
                if (viewModel.userData.image != "") {
                    AsyncImage(
                        modifier = Modifier
                            .size(115.dp)
                            .clip(CircleShape),
                        model = viewModel.userData.image,
                        contentDescription = "User image",
                        contentScale = ContentScale.Crop
                    )
                }
                else {
                    Image(
                        modifier = Modifier.size(115.dp),
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = ""
                    )
                }

            }

        }

        Spacer(modifier = Modifier.height(55.dp))
        Text(
            text = viewModel.userData.username,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            color = Color.White

        )
        Text(
            text = viewModel.userData.email,
            fontSize = 15.sp,
            fontStyle = FontStyle.Italic,
            color = Color.White

        )
        Spacer(modifier = Modifier.height(20.dp))
        DefaultButton(
            text = "Editar datos",
            icon = Icons.Default.Edit,
            onClick = {
                navController.navigate(
                    route = DetailsScreen.ProfileUpdate.passUser(viewModel.userData.toJson())
                )
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        DefaultButton(
            text = "Cerrar sesion",
            onClick = {
                viewModel.logout()
                activity?.finish()
                activity?.startActivity(Intent(activity, MainActivity::class.java))
            }
        )

    }

}