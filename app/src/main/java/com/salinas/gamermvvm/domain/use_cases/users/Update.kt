package com.salinas.gamermvvm.domain.use_cases.users

import com.salinas.gamermvvm.domain.model.User
import com.salinas.gamermvvm.domain.repository.UsersRepository
import javax.inject.Inject

class Update @Inject constructor(private val repository: UsersRepository) {
    suspend operator fun invoke(user: User) = repository.update(user)
}