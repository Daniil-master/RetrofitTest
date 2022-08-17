package com.daniilmaster.retrofittest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daniilmaster.retrofittest.model.Post
import com.daniilmaster.retrofittest.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponseList: MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun getPosts() {
        viewModelScope.launch {
            val response: Response<List<Post>> = repository.getPosts()
            myResponseList.value = response
        }
    }

}