package com.salinas.gamermvvm.domain.use_cases.users

import com.salinas.gamermvvm.domain.repository.UsersRepository
import javax.inject.Inject

class GetUserById @Inject constructor(private val repository: UsersRepository){
    operator fun invoke(id: String) = repository.getUserById(id)
}