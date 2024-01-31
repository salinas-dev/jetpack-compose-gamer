package com.salinas.gamermvvm.presentation.screens.signup.components

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
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Lock
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
import com.salinas.gamermvvm.presentation.screens.signup.SignupViewModel
import com.salinas.gamermvvm.presentation.ui.theme.Blue200

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupContent(navController: NavController, viewModel: SignupViewModel = hiltViewModel()) {

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
                .height(270.dp)
                .background(Blue200)
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(80.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = "Imagen usuario",
                    modifier = Modifier.height(100.dp) // Ajusta la altura según tus necesidades
                )
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
                    text = "REGISTRO"
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
                    errorMg = viewModel.usernameErrorMsg,
                    valitdateField = {
                        viewModel.validateUsername()
                    },
                )
                DefaultTextField(
                    value = state.email,
                    onValueChange = { viewModel.onEmailInput(it) },
                    modifier = Modifier.padding(top = 5.dp) ,
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
                    hideText = true,
                    errorMg = viewModel.passwordErrorMsg,
                    valitdateField = {
                        viewModel.validatePassword()
                    }
                )
                DefaultTextField(
                    value = state.confirmPassword,
                    onValueChange = { viewModel.onConfirmPasswordInput(it) },
                    modifier = Modifier.padding(top = 5.dp) ,
                    label = "Confirmar contraseña",
                    icon = Icons.Outlined.Lock,
                    hideText = true,
                    errorMg = viewModel.passwordErrorMsg,
                    valitdateField = {
                        viewModel.validateConfirmPassword()
                    }
                )

                DefaultButton(
                    text = "REGISTRARSE",
                    onClick = {
                        viewModel.onSignup()
                    }
                )

            }
        }
    }
}
