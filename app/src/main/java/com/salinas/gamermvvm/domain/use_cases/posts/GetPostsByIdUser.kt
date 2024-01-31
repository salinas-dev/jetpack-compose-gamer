package com.salinas.gamermvvm.domain.use_cases.posts

import com.salinas.gamermvvm.domain.repository.PostsRepository
import javax.inject.Inject

class GetPostsByIdUser @Inject constructor(private val repository: PostsRepository) {

    operator fun invoke(idUser: String) = repository.getPostsByUserId(idUser)

}