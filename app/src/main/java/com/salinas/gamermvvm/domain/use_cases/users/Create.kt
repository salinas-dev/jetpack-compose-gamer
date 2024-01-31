package com.salinas.gamermvvm.domain.use_cases.users

import com.salinas.gamermvvm.domain.model.User
import com.salinas.gamermvvm.domain.repository.UsersRepository
import javax.inject.Inject

class Create @Inject constructor(private val repository: UsersRepository){
    suspend operator fun invoke(user:User) = repository.create(user)
}