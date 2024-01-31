package com.salinas.gamermvvm.domain.use_cases.posts

data class PostsUsesCases (
    val create: CreatePost,
    val getPosts: GetPosts,
    val getPostsByIdUser: GetPostsByIdUser,
    val deletePost: DeletePost,
    val updatePost: UpdatePost,
    val likePost: LikePost,
    val deleteLikePost: DeleteLikePost
)