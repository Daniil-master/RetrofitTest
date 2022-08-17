package com.daniilmaster.retrofittest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.daniilmaster.retrofittest.R
import com.daniilmaster.retrofittest.model.Post
import retrofit2.Response

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var myList = emptyList<Post>()
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.itemView.findViewById<TextView>(R.id.tvUserId).text = myList[position].userId.toString()
       holder.itemView.findViewById<TextView>(R.id.tvId).text = myList[position].id.toString()
       holder.itemView.findViewById<TextView>(R.id.tvTitle).text= myList[position].title
       holder.itemView.findViewById<TextView>(R.id.tvBody).text= myList[position].body
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    fun setData(newList: List<Post>){
        myList = newList
        notifyDataSetChanged()
    }


}