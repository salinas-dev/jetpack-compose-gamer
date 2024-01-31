package com.salinas.gamermvvm.presentation.screens.signup

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.salinas.gamermvvm.domain.model.Response
import com.salinas.gamermvvm.domain.model.User
import com.salinas.gamermvvm.domain.use_cases.auth.AuthUseCases
import com.salinas.gamermvvm.domain.use_cases.users.UsersUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(private val authUseCases: AuthUseCases, private val userUseCases: UsersUseCases): ViewModel() {
    //State form
    var state by mutableStateOf(SignupState())
        private set

    //User
    var isUsernameValid by mutableStateOf(false)
        private set

    var usernameErrorMsg by mutableStateOf("")
        private set

    //Email
    var isEmailValid by mutableStateOf(false)
        private set

    var emailErrorMsg by mutableStateOf("")
        private set

    //Password
    var isPasswordValid by mutableStateOf(false)
        private set

    var passwordErrorMsg by mutableStateOf("")
        private set

    //Cozntraseña
    var isPassCfValid by mutableStateOf(false)
        private set

    var passCfErrorMsg by mutableStateOf("")
        private set

    var signupResponse by mutableStateOf<Response<FirebaseUser>?>(null)
        private set

    var user = User()

    fun onEmailInput(email: String) {
        state = state.copy(email = email)
    }

    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }

    fun onUsernameInput(username: String) {
        state = state.copy(username = username)
    }

    fun onConfirmPasswordInput(confirmPassword: String) {
        state = state.copy(confirmPassword = confirmPassword)
    }

    fun onSignup() {

        user.username = state.username
        user.email = state.email
        user.password = state.password
        user.confirmPassword = state.confirmPassword
        signup(user)

    }

    fun createUser() = viewModelScope.launch {
        user.id = authUseCases.getCurrentUser()!!.uid
        userUseCases.create(user)
    }

    fun signup(user: User) = viewModelScope.launch {
        signupResponse = Response.Loading
        val result = authUseCases.signup(user)
        signupResponse = result
    }



    //Button
    var isEnableLoginButton = false

    fun enableLoginButton(){
        isEnableLoginButton =
            isEmailValid && isPasswordValid && isUsernameValid && isPassCfValid
    }


    fun validateUsername(){
        if(state.username.length >= 5){
            isUsernameValid = true
            usernameErrorMsg = ""
        }else {
            isUsernameValid= true
            usernameErrorMsg = "Al emnos 5 caracteres"
        }
        enableLoginButton()

    }

    fun validateEmail(){
        if(Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            isEmailValid = true
            emailErrorMsg = ""
        }
        else{
            isEmailValid = false
            emailErrorMsg = "El correo no es valido"
        }
        enableLoginButton()
    }

    fun validatePassword(){
        if(state.password.length >= 6){
            isPasswordValid = true
            passwordErrorMsg = ""
        }
        else{
            isPasswordValid = false
            passwordErrorMsg = "Al menos 6 caracteres"
        }
        enableLoginButton()
    }

    fun validateConfirmPassword() {
        if (state.password == state.confirmPassword) {
            isPassCfValid = true
            passCfErrorMsg = ""
        } else {
            isPassCfValid = false  // Corregir el nombre de la variable aquí
            passCfErrorMsg = "Las contraseñas no coinciden"
        }
        enableLoginButton()
    }
}