package com.salinas.gamermvvm.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.salinas.gamermvvm.domain.model.Response
import com.salinas.gamermvvm.domain.model.User
import com.salinas.gamermvvm.domain.repository.AuthRepository
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val firebaseAuth: FirebaseAuth): AuthRepository {

    override val currentUser: FirebaseUser? get() = firebaseAuth.currentUser

    override suspend fun login(email: String, password: String): Response<FirebaseUser> {
        return try {
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            Response.Success(result.user!!)

        } catch (e: Exception){
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    override suspend fun signUp(user: User): Response<FirebaseUser> {
        return try {
            val result = firebaseAuth.createUserWithEmailAndPassword(user.email, user.password).await()
            sendVerificationEmail(result.user!!)
            Response.Success(result.user!!)
        } catch (e: Exception){
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    private suspend fun sendVerificationEmail(user: FirebaseUser) {
        user.sendEmailVerification().await()
    }



    override fun logout() {
        firebaseAuth.signOut()
    }
}