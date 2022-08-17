package com.daniilmaster.retrofittest

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daniilmaster.retrofittest.adapter.MyAdapter
import com.daniilmaster.retrofittest.model.Post
import com.daniilmaster.retrofittest.repository.Repository
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy { MyAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        setupViewModel()
    }

    private fun setupRecyclerView() {
        val recycler: RecyclerView = findViewById(R.id.recyclerView)
        recycler.adapter = myAdapter
        recycler.layoutManager = LinearLayoutManager(this)
    }

    private fun setupViewModel() {
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.getPosts()
        viewModel.myResponseList.observe(this) { response ->
            if (response.isSuccessful) {
                val a: Response<List<Post>>? = viewModel.myResponseList.value
                myAdapter.setData(a?.body()!!)
                myAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "${response.code()} ", Toast.LENGTH_SHORT).show()
            }
        }
    }

}