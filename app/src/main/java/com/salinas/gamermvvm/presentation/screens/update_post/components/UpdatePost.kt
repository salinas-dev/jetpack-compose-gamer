package com.salinas.gamermvvm.presentation.screens.update_post.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.salinas.gamermvvm.domain.model.Response
import com.salinas.gamermvvm.presentation.components.ProgressBar
import com.salinas.gamermvvm.presentation.screens.update_post.UpdatePostViewModel

@Composable
fun UpdatePost(viewModel: UpdatePostViewModel = hiltViewModel()) {

    when(val response = viewModel.updatePostResponse) {
        // MOSTRAR QUE SE ESTA REALIZANDO LA PETICION Y TODAVIA ESTA EN PROCESO
        Response.Loading -> {
            ProgressBar()
        }
        is Response.Success -> {
            viewModel.clearForm()
            Toast.makeText(LocalContext.current, "La publicacion se ha actualizo correctamente", Toast.LENGTH_LONG).show()
        }
        is Response.Failure -> {
            Toast.makeText(LocalContext.current, response.exception?.message ?: "Error desconido", Toast.LENGTH_LONG).show()
        }

        else -> {}
    }

}