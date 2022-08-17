package com.daniilmaster.retrofittest.repository

import com.daniilmaster.retrofittest.api.RetrofitInstance
import com.daniilmaster.retrofittest.model.Post
import retrofit2.Response

class Repository {
    suspend fun getPosts(): Response<List<Post>> {
        return RetrofitInstance.api.getPosts()
    }

}