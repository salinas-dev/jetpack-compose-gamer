package com.salinas.gamermvvm.domain.use_cases.auth

import com.salinas.gamermvvm.data.repository.AuthRepositoryImpl
import com.salinas.gamermvvm.domain.repository.AuthRepository
import javax.inject.Inject

class Login @Inject constructor(private val repository: AuthRepository){

    suspend operator fun invoke(email: String, password:String) = repository.login(email, password)
}