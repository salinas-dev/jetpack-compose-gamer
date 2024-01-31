package com.salinas.gamermvvm.domain.repository

import com.google.firebase.firestore.auth.User as FirebaseUser
import com.salinas.gamermvvm.domain.model.User as DomainUser
import com.salinas.gamermvvm.domain.model.Response
import kotlinx.coroutines.flow.Flow
import java.io.File

interface UsersRepository {
    suspend fun create(user: FirebaseUser): Response<Boolean>
    suspend fun create(user: DomainUser): Response<Boolean>
    suspend fun update(username: DomainUser): Response<Boolean>
    suspend fun saveImage(file: File): Response<String>
    fun getUserById(id: String): Flow<DomainUser>
}
