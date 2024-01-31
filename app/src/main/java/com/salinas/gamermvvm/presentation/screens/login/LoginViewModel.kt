package com.salinas.gamermvvm.presentation.screens.login

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.salinas.gamermvvm.domain.model.Response
import com.salinas.gamermvvm.domain.use_cases.auth.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCases: AuthUseCases): ViewModel() {
    //State form
    var state by mutableStateOf(LoginState())
        private set

    //Email
    var isEmailValid by mutableStateOf(false)
        private set

    var emailErrorMsg by mutableStateOf("")
        private set


    //Password
    var isPasswordValid by  mutableStateOf(false)
        private set

    var passwordErrorMsg by mutableStateOf("")
        private set


    //Button
    var isEnableLoginButton = false

    //Login state
    var loginResponse by mutableStateOf<Response<FirebaseUser>?>(null)

    private val _toastMessage = MutableStateFlow<String?>(null)
    val toastMessage: StateFlow<String?> = _toastMessage

    val currentUser = authUseCases.getCurrentUser()
    init {
        if(currentUser != null && currentUser.isEmailVerified){
            loginResponse = Response.Success(currentUser)
        }
    }

    fun onEmailInput(email: String){
        state = state.copy(email = email)
    }

    fun onPasswordInput(password: String){
        state = state.copy(password = password)
    }


    fun login() = viewModelScope.launch {

        loginResponse = Response.Loading
        val result = authUseCases.login(state.email, state.password)

        if (result is Response.Success) {
            // El login fue exitoso, pero verifica si el correo electrónico está verificado
            checkEmailVerification(result.data!!)
        } else {
            // El login falló, actualiza el estado directamente
            loginResponse = result
            _toastMessage.value = "Verifique su correo e inicie sesión"
        }

    }

    private fun checkEmailVerification(user: FirebaseUser) {
        if (user.isEmailVerified) {
            // El correo electrónico está verificado, actualiza el estado con éxito
            loginResponse = Response.Success(user)
        } else {
            // El correo electrónico no está verificado, actualiza el estado con un mensaje de error
            loginResponse = Response.Failure(Exception("Verifica tu correo electrónico"))

        }
    }

    fun enableLoginButton(){
        isEnableLoginButton = isEmailValid && isPasswordValid
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
}