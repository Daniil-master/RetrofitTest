package com.daniilmaster.retrofittest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daniilmaster.retrofittest.model.Post
import com.daniilmaster.retrofittest.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponseByNum: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponseListByNum: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val myResponseListByNum2: MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response
        }
    }

    fun getPosts() {
        viewModelScope.launch {
            val response: Response<List<Post>> = repository.getPosts()
            myResponseListByNum.value = response
        }
    }


    fun getPostNumber(number: Int) {
        viewModelScope.launch {
            val response = repository.getPostNumber(number)
            myResponseByNum.value = response
        }
    }

    fun getListByNumCustomPosts(userId: Int, sort: String, order: String) {
        viewModelScope.launch {
            val response: Response<List<Post>> = repository.getCustomPosts(userId, sort, order)
            myResponseListByNum.value = response
        }
    }

    fun getCustomPosts2(userId: Int, options: Map<String, String>) {
        viewModelScope.launch {
            val response = repository.getCustomPosts2(userId, options)
            myResponseListByNum2.value = response
        }
    }

    fun pushPost(post: Post){
        viewModelScope.launch {
            val response = repository.pushPost(post)
            myResponse.value = response
        }
    }
    fun pushPost2(userId: Int, id: Int, title: String, body: String){
        viewModelScope.launch {
            val response = repository.pushPost2(userId, id, title, body)
            myResponse.value = response
        }
    }
}