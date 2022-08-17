package com.daniilmaster.retrofittest.api

import com.daniilmaster.retrofittest.model.Post
import retrofit2.Response
import retrofit2.http.*

interface SimpleApi {

    @GET("posts/")
    suspend fun getPosts(): Response<List<Post>>

}