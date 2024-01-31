package com.salinas.gamermvvm.domain.model

import com.google.gson.Gson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class User(
    var id: String = "",
    var username: String = "",
    var email: String = "",
    var password: String = "",
    var confirmPassword: String = "",
    var image: String = ""

){
    fun toJson(): String = Gson().toJson(User(
        id,
        username,
        email,
        password,
        confirmPassword,
        if(image != "") URLEncoder.encode(image, StandardCharsets.UTF_8.toString()) else ""

    ))

    companion object {
        fun fromJson(data: String): User = Gson().fromJson(data, User::class.java)

    }
}
