package com.salinas.gamermvvm.presentation.screens.profile_edit.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.salinas.gamermvvm.presentation.components.DefaultButton
import com.salinas.gamermvvm.presentation.components.DefaultTextField
import com.salinas.gamermvvm.presentation.components.DialogCapturePicture
import com.salinas.gamermvvm.presentation.screens.profile_edit.ProfileEditViewModel
import com.salinas.gamermvvm.presentation.ui.theme.Blue200


@Composable
fun ProfileEditContent(navController: NavHostController, viewModel: ProfileEditViewModel = hiltViewModel()) {

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


    //Todos los componentes empiezan con mayusculas
    Box(
        //modifier --> Establecer el ancho, alto, color, padding y etc.
        //fillMaxWidth --> T-odo el ancho de la pantalla.
        //wrapContentHeight --> Ocupe el tamañano que contiene los elementos no toda la pantalla.
        modifier = Modifier
            .fillMaxWidth(),
        /*.wrapContentHeight()
        .background(Color.Red),*/
        //CenterHorizontally --> Centrar todos los elementos que estan en la columna.
    ) {
        /*Imagen con dos propiedades:
        *painter --> id: donde tenemos nuesta imagen
        *contentDescription --> Descripcion de la imagen
        * */

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(270.dp)
                .background(Blue200)
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(80.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                if (viewModel.state.image != ""){
                    AsyncImage(
                        modifier = Modifier
                            .height(100.dp)
                            .width(100.dp)
                            .clip(CircleShape)
                            .clickable {
                                dialogState.value = true
                            },
                        model = viewModel.state.image,
                        contentDescription = "Selected image",
                        contentScale = ContentScale.Crop
                    )
                }else{
                    Image(
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = "Imagen usuario",
                        modifier = Modifier
                            .height(120.dp)
                            .width(120.dp)
                            .clip(CircleShape)
                            .clickable {
                                dialogState.value = true
                            } // Ajusta la altura según tus necesidades
                    )
                }
            }
        }


        Card(
            modifier = Modifier
                .padding(top = 200.dp, start = 40.dp, end = 40.dp) ,// Establece el color de fondo aquí
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
            ) {
                Text(
                    //Separacion o padding
                    /*
                    Especificando cada area o arriba abajo: top = 15.dp
                    * Uno para t-odo: 15.dp
                    */
                    modifier = Modifier
                        .padding(
                            top = 40.dp,
                            end = 0.dp,
                            start = 0.dp,
                            bottom = 0.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    text = "ACTUALIZAR"
                )
                //Otra manera para separar altura(height)
                Spacer(
                    modifier = Modifier.height(10.dp)
                )
                Text(
                    fontSize = 12.sp,
                    color = Color.Gray,
                    text = "Por favor estos datos para continuar"
                )
                DefaultTextField(
                    value = state.username,
                    onValueChange = { viewModel.onUsernameInput(it) },
                    modifier = Modifier.padding(top = 25.dp) ,
                    label = "Nombre de usuario",
                    icon = Icons.Default.Person ,
                    valitdateField = {
                        viewModel.validateUsername()
                    },
                )
                DefaultButton(
                    text = "ACTUALIZAR PERFIL",
                    onClick = {
                        viewModel.saveImage()
                    }
                )

            }
        }
    }
}