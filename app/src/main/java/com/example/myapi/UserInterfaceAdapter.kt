package com.example.myapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapi.model.UsersItem

class UsersItemAdapter(private val usersItems: List<UsersItem>) : RecyclerView.Adapter<UsersItemAdapter.UsersItemViewHolder>() {

    class UsersItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(android.R.id.text1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false)
        return UsersItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsersItemViewHolder, position: Int) {
        holder.title.text = usersItems[position].title
    }

    override fun getItemCount() = usersItems.size
}
