package com.daniilmaster.retrofittest.model

import com.google.gson.annotations.SerializedName

data class Post(
//    @SerializedName("userId") // при ином имени в коде
    val userId: Int,
    val id:Int,
    val title: String,
    val body: String
)