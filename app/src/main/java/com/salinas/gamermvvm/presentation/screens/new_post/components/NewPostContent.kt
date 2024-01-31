package com.salinas.gamermvvm.presentation.screens.new_post.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.salinas.gamermvvm.R
import com.salinas.gamermvvm.presentation.components.DefaultTextField
import com.salinas.gamermvvm.presentation.components.DialogCapturePicture
import com.salinas.gamermvvm.presentation.screens.new_post.NewPostViewModel
import com.salinas.gamermvvm.presentation.ui.theme.Blue200
import com.salinas.gamermvvm.presentation.ui.theme.GamerMVVMTheme

@Composable
fun NewPostContent(viewModel: NewPostViewModel = hiltViewModel()){

    val state = viewModel.state
    viewModel. resultingActivityHandler.handle()
    var dialogState = remember { mutableStateOf(false) }

    DialogCapturePicture(
        status = dialogState,
        takePhoto = {
            viewModel.takePhoto()
        },
        pickImage = {
            viewModel.pickImage()
        }
    )

    Box(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        /*Imagen con dos propiedades:
        *painter --> id: donde tenemos nuesta imagen
        *contentDescription --> Descripcion de la imagen
        * */
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .background(Blue200)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                    if (viewModel.state.image != ""){
                        AsyncImage(
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .height(240.dp)
                                .clickable {
                                    dialogState.value = true
                                },
                            model = viewModel.state.image,
                            contentDescription = "Selected image",
                            contentScale = ContentScale.Crop
                        )
                    }else{
                        Image(
                            painter = painterResource(id = R.drawable.add_image),
                            contentDescription = "Imagen usuario",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .padding(top = 80.dp)                                .width(120.dp)
                                .clickable {
                                    dialogState.value = true
                                } // Ajusta la altura según tus necesidades
                        )
                        Text(
                            text = "SELECCIONA UNA IMAGEN",
                            fontSize = 19.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
            DefaultTextField(
                value = state.name,
                onValueChange = { viewModel.onNameInput(it) },
                modifier = Modifier
                    .padding(top = 29.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth(),
                label = "Nombre del juego",
                icon = Icons.Default.Face ,
                errorMg = "",
                valitdateField = {  }
            )
            DefaultTextField(
                value = state.description,
                onValueChange = { viewModel.onDescriptionInput(it) },
                modifier = Modifier
                    .padding(top = 0.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth(),
                label = "Descripcion",
                icon = Icons.Default.List ,
                errorMg = "",
                valitdateField = {  }
            )
            Text(
                modifier = Modifier
                    .padding(vertical = 15.dp),
                text = "CATEGORIAS",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            viewModel.radioOptions.forEach { option ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .selectable(
                            selected = (option.category == state.category),
                            onClick = { viewModel.onCategoryInput(option.category) }
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (option.category == state.category),
                        onClick = { viewModel.onCategoryInput(option.category) }
                    )
                    Row() {
                        Text(
                            modifier = Modifier
                                .width(110.dp)
                                .padding(12.dp),
                            text = option.category
                        )
                        Image(
                            modifier = Modifier
                                .height(50.dp)
                                .padding(8.dp),
                            painter = painterResource(id = option.image),
                            contentDescription = ""
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultNewPostContent() {
    GamerMVVMTheme(darkTheme = true) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NewPostContent()
        }
    }
}