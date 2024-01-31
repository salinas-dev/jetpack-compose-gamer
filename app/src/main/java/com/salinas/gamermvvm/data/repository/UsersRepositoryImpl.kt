package com.salinas.gamermvvm.data.repository

import android.net.Uri
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.storage.StorageReference
import com.salinas.gamermvvm.core.Constants.USERS
import com.salinas.gamermvvm.domain.model.Response
import com.salinas.gamermvvm.domain.model.User
import com.salinas.gamermvvm.domain.repository.UsersRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import java.io.File
import javax.inject.Inject
import javax.inject.Named

class UsersRepositoryImpl @Inject constructor(
    @Named(USERS) private val usersRef: CollectionReference,
    @Named(USERS) private val storageUsersRef: StorageReference
): UsersRepository {

    override suspend fun create(user: User): Response<Boolean> {
        return try {
            // Omitir la contraseña y la confirmación al crear el usuario
            user.password = ""
            user.confirmPassword = ""
            usersRef.document(user.id).set(user).await()
            Response.Success(true)
        } catch (e: Exception) {
            // Manejar excepciones de manera específica
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    override suspend fun update(user: User): Response<Boolean> {
        return try {
            // Actualizar solo el nombre de usuario y la imagen
            val map: MutableMap<String, Any> = HashMap()
            map["username"] = user.username
            map["image"] = user.image

            usersRef.document(user.id).update(map).await()
            Response.Success(true)
        } catch (e: Exception) {
            // Manejar excepciones de manera específica
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    override suspend fun saveImage(file: File): Response<String> {
        return try {
            val fromFile = Uri.fromFile(file)
            val ref = storageUsersRef.child(file.name)
            val uploadTask = ref.putFile(fromFile).await()
            val url = ref.downloadUrl.await()
            Response.Success(url.toString())
        } catch (e: Exception) {
            // Manejar excepciones de manera específica
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    override fun getUserById(id: String): Flow<User> = callbackFlow {
        val snapshotListener = usersRef.document(id).addSnapshotListener { snapshot, e ->
            if (e != null) {
                // Manejar errores de manera específica
                trySend(User()) // Enviar un usuario vacío en caso de error
            } else {
                val user = snapshot?.toObject(User::class.java) ?: User()
                trySend(user)
            }
        }
        awaitClose {
            snapshotListener.remove()
        }
    }

    override suspend fun create(user: com.google.firebase.firestore.auth.User): Response<Boolean> {
        // Implementa la lógica para el usuario de Firebase aquí
        // Puedes devolver Success o Failure según sea necesario
        TODO("Not yet implemented")
    }
}
