package com.salinas.gamermvvm.di;

import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.salinas.gamermvvm.core.Constants
import com.salinas.gamermvvm.data.repository.AuthRepositoryImpl
import com.salinas.gamermvvm.data.repository.PostsRepositoryImpl
import com.salinas.gamermvvm.data.repository.UsersRepositoryImpl
import com.salinas.gamermvvm.domain.repository.AuthRepository
import com.salinas.gamermvvm.domain.repository.PostsRepository
import com.salinas.gamermvvm.domain.repository.UsersRepository
import com.salinas.gamermvvm.domain.use_cases.auth.*
import com.salinas.gamermvvm.domain.use_cases.posts.*
import com.salinas.gamermvvm.domain.use_cases.users.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named



@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideFirebaseFirestore(): FirebaseFirestore = Firebase.firestore

    @Provides
    fun provideFirebaseStorage(): FirebaseStorage = FirebaseStorage.getInstance()

    @Provides
    @Named(Constants.USERS)
    fun provideStorageUsersRef(storage: FirebaseStorage): StorageReference = storage.reference.child(
        Constants.USERS)

    @Provides
    @Named(Constants.USERS)
    fun provideUsersRef(db: FirebaseFirestore): CollectionReference = db.collection(Constants.USERS)

    @Provides
    @Named(Constants.POSTS)
    fun provideStoragePostsRef(storage: FirebaseStorage): StorageReference = storage.reference.child(
        Constants.POSTS)

    @Provides
    @Named(Constants.POSTS)
    fun providePostsRef(db: FirebaseFirestore): CollectionReference = db.collection(Constants.POSTS)

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl

    @Provides
    fun provideUsersRepository(impl: UsersRepositoryImpl): UsersRepository = impl

    @Provides
    fun providePostsRepository(impl: PostsRepositoryImpl): PostsRepository = impl

    @Provides
    fun provideAuthUseCases(repository: AuthRepository) = AuthUseCases(
        getCurrentUser = GetCurrentUser(repository),
        login = Login(repository),
        logout = Logout(repository),
        signup = Signup(repository)
    )
    @Provides
    fun provideUsersUseCases(repository: UsersRepository) = UsersUseCases(
        create = Create(repository),
        getUserById = GetUserById(repository),
        update = Update(repository),
        saveImage = SaveImage(repository)
    )
    @Provides
    fun providePostsUseCases(repository: PostsRepository) = PostsUseCases(
        create = CreatePost(repository),
        getPosts = GetPosts(repository),
        getPostsByIdUser = GetPostsByIdUser(repository),
        deletePost = DeletePost(repository),
        updatePost = UpdatePost(repository),
        likePost = LikePost(repository),
        deleteLikePost = DeleteLikePost(repository)
    )

}
