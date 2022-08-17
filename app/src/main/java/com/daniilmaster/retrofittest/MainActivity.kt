package com.daniilmaster.retrofittest

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daniilmaster.retrofittest.adapter.MyAdapter
import com.daniilmaster.retrofittest.model.Post
import com.daniilmaster.retrofittest.repository.Repository
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy { MyAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)


//        viewModel.getPost()
        viewModel.getPosts()
//        viewModel.getPostNumber(2)
//        viewModel.getListByNumCustomPosts(2, "id", "desc")
//        val options: HashMap<String, String> = HashMap()
//        options["_sort"] = "id"
//        options["_order"] = "desc"
//        viewModel.getCustomPosts2(2, options)
//        val myPost = Post(2, 2, "Title", "Description")
//        viewModel.pushPost(myPost)
//        viewModel.pushPost2(2, 2, "Title", "Description")
        viewModel.myResponseListByNum.observe(this, Observer { response ->
            if (response.isSuccessful) {
//                Log.d(TAG, "onCreate: Body:" + response.body().toString())
//                Log.d(TAG, "onCreate: Code:" + response.code().toString())
//                Log.d(TAG, "onCreate: Message:" + response.message())
//                val post: Post = viewModel.myResponse.value?.body()!!
//                myAdapter.setData(listOf(post))
                val a: Response<List<Post>>? = viewModel.myResponseListByNum.value
                myAdapter.setData(a?.body()!!)
//                myAdapter.setData(listOf(viewModel.myResponseByNum.value?.body()!!))
//                myAdapter.setData(viewModel.myResponseListByNum.value?.body()!!)
//                myAdapter.setData(viewModel.myResponseListByNum2.value?.body()!!)
//                myAdapter.setData(listOf(viewModel.myResponse.value?.body()!!))

            } else {
                Toast.makeText(this, "${response.code()} ", Toast.LENGTH_SHORT).show()
            }
        })
//        viewModel.myResponseListByNum.observe(this, Observer { response ->
//            if (response.isSuccessful) {
//                response.body()?.let { myAdapter.setData(it) }
//            } else {
//                Toast.makeText(this, "${response.code()} ", Toast.LENGTH_SHORT).show()
//            }
//        })


//        viewModel.getPost()

//        txtView = findViewById(R.id.txtView)
//        viewModel.myResponse.observe(this, Observer { response ->
////            Log.d(TAG, "Response userId: ${response.userId}, id: ${response.id}, title: ${response.title}, body: ${response.body}")
//            if (response.isSuccessful) {
//                val resp = response.body()!!
//                Log.d(
//                    TAG,
//                    "Response userId: ${resp.userId}, " +
//                            "id: ${resp.id}, " +
//                            "title: ${resp.title}, " +
//                            "body: ${resp.body}"
//                )
//
//            }else{
//                Log.d(
//                    TAG,"Response code: ${response.code()}, " +
//                            "\nerrorBody: ${response.errorBody().toString()} ")
//            }
//        })


    }

    private fun setupRecyclerView() {
        val recycler: RecyclerView = findViewById(R.id.recyclerView)
        recycler.adapter = myAdapter
        recycler.layoutManager = LinearLayoutManager(this)

    }

    fun onClickGet(view: View) {
//        val number = findViewById<EditText>(R.id.editTextNumber).text.toString().toInt()
//        viewModel.getPostNumber(number)
//        viewModel.myResponseByNum.observe(this, Observer { response ->
////            Log.d(TAG, "Response userId: ${response.userId}, id: ${response.id}, title: ${response.title}, body: ${response.body}")
//            if (response.isSuccessful) {
//                txtView.text = response.body().toString()
//                val resp = response.body()!!
//                Log.d(
//                    TAG,
//                    "Response userId: ${resp.userId}, " +
//                            "id: ${resp.id}, " +
//                            "title: ${resp.title}, " +
//                            "body: ${resp.body}"
//                )
//
//            }else{
//                txtView.text = response.errorBody().toString()
//                Log.d(
//                    TAG,"Response code: ${response.code()}, " +
//                            "\nerrorBody: ${response.errorBody().toString()} ")
//            }
//        })

//        val number = findViewById<EditText>(R.id.editTextNumber).text.toString().toInt()
//        viewModel.getCustomPosts(number, "id","desc")
//        viewModel.myResponseListByNum.observe(this, Observer { response ->
//
//         if (response.isSuccessful) {
//                txtView.text = response.body().toString()
//                val resp = response.body()!!
//                resp.forEach {
//                    Log.d(
//                        TAG,
//                        "Response userId: ${it.userId}, " +
//                                "id: ${it.id}, " +
//                                "title: ${it.title}, " +
//                                "body: ${it.body}"
//                    )
//                }
//
//
//            }else{
//                txtView.text = response.errorBody().toString()
//                Log.d(
//                    TAG,"Response code: ${response.code()}, " +
//                            "\nerrorBody: ${response.errorBody().toString()} ")
//            }
//        })


//        val options: HashMap<String, String> = HashMap()
//        options["_sort"] = "id"
//        options["_order"] = "desc"
//
//        val number = findViewById<EditText>(R.id.editTextNumber).text.toString().toInt()
//        viewModel.getCustomPosts2(number, options)
//        viewModel.myResponseListByNum2.observe(this, Observer { response ->
//
//            if (response.isSuccessful) {
//                txtView.text = response.body().toString()
//                val resp = response.body()!!
//                resp.forEach {
//                    Log.d(
//                        TAG,
//                        "Response userId: ${it.userId}, " +
//                                "id: ${it.id}, " +
//                                "title: ${it.title}, " +
//                                "body: ${it.body}"
//                    )
//                }
//
//
//            } else {
//                txtView.text = response.errorBody().toString()
//                Log.d(
//                    TAG, "Response code: ${response.code()}, " +
//                            "\nerrorBody: ${response.errorBody().toString()} "
//                )
//            }
//        })

    }
}