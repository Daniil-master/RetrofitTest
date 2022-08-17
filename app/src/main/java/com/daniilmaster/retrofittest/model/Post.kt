package com.daniilmaster.retrofittest.model

data class Post(
//    @SerializedName("userId") // при ином имени в коде
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)