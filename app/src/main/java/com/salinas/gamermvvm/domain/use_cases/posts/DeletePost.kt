package com.salinas.gamermvvm.domain.use_cases.posts

import com.salinas.gamermvvm.domain.model.Post
import com.salinas.gamermvvm.domain.repository.PostsRepository
import java.io.File
import javax.inject.Inject

class DeletePost @Inject constructor(private val repository: PostsRepository){

    suspend operator fun invoke(idPost: String) = repository.delete(idPost)

}