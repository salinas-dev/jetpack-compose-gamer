package com.salinas.gamermvvm.presentation.screens.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.salinas.gamermvvm.R
import com.salinas.gamermvvm.presentation.components.DefaultButton
import com.salinas.gamermvvm.presentation.components.DefaultTextField
import com.salinas.gamermvvm.presentation.screens.login.LoginViewModel
import com.salinas.gamermvvm.presentation.ui.theme.Blue200

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginContent(navController: NavController, viewModel: LoginViewModel = hiltViewModel()) {

    val state = viewModel.state
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
                .height(280.dp)
                .background(Blue200)
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(id = R.drawable.control),
                    contentDescription = "Control de xbox 360",
                    modifier = Modifier.height(130.dp) // Ajusta la altura según tus necesidades
                )
                Text(
                    text = "GAMER´s FIREBASE"
                )
            }
        }


        Card(
            modifier = Modifier
                .padding(top = 190.dp, start = 40.dp, end = 40.dp) ,// Establece el color de fondo aquí
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
                    text = "INICIAR SESIÓN"
                )
                //Otra manera para separar altura(height)
                Spacer(
                    modifier = Modifier.height(10.dp)
                )
                Text(
                    fontSize = 12.sp,
                    color = Color.Gray,
                    text = "Por favor inicia sesion para continuar"
                )
                DefaultTextField(
                    value = state.email,
                    onValueChange = { viewModel.onEmailInput(it) },
                    modifier = Modifier.padding(top = 25.dp) ,
                    label = "Correo Electronico",
                    icon = Icons.Default.Email ,
                    keyboardType = KeyboardType.Email,
                    errorMg = viewModel.emailErrorMsg,
                    valitdateField = {
                        viewModel.validateEmail()
                    }
                )
                DefaultTextField(
                    value = state.password,
                    onValueChange = { viewModel.onPasswordInput(it) },
                    modifier = Modifier.padding(top = 5.dp) ,
                    label = "Contraseña",
                    icon = Icons.Default.Lock ,
                    keyboardType = KeyboardType.Password,
                    hideText = true,
                    errorMg = viewModel.passwordErrorMsg,
                    valitdateField = {
                        viewModel.validatePassword()
                    }
                )

                DefaultButton(
                    text = "INICIAR SESIÓN",
                    onClick = {
                              viewModel.login()
                    },
                    enabled = viewModel.isEnableLoginButton
                )
            }
        }
    }
}

/*
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    GamerMVVMTheme(darkTheme = true) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LoginContent(null)
        }
    }
}*/