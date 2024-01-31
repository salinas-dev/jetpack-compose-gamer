package com.salinas.gamermvvm.domain.use_cases.posts

import com.salinas.gamermvvm.domain.model.Post
import com.salinas.gamermvvm.domain.repository.PostsRepository
import javax.inject.Inject
import java.io.File


class CreatePost @Inject constructor(private val repository: PostsRepository) {
    suspend operator fun invoke(post: Post, file: File) = repository.create(post, file)
}