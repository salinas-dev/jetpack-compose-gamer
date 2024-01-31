package com.salinas.gamermvvm.domain.use_cases.auth

import com.salinas.gamermvvm.domain.model.User
import com.salinas.gamermvvm.domain.repository.AuthRepository
import javax.inject.Inject

class Signup @Inject constructor(private val repository: AuthRepository) {
    suspend operator fun invoke(user: User) = repository.signUp(user)
}