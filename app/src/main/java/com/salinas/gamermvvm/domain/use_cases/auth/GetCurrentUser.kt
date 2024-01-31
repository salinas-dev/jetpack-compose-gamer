package com.salinas.gamermvvm.domain.use_cases.auth

import com.salinas.gamermvvm.domain.repository.AuthRepository
import javax.inject.Inject

class GetCurrentUser @Inject constructor(private val repository: AuthRepository) {
    operator fun invoke() = repository.currentUser
}