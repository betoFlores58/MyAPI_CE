package com.example.myapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapi.model.UsersItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchUsersItems()
    }

    private fun fetchUsersItems() {
        RetrofitInstance.api.getUsersItems().enqueue(object : Callback<List<UsersItem>> {
            override fun onResponse(call: Call<List<UsersItem>>, response: Response<List<UsersItem>>) {
                if (response.isSuccessful && response.body() != null) {
                    recyclerView.adapter = UsersItemAdapter(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<UsersItem>>, t: Throwable) {
                // Nadaaaaaaaaaaaaaaaaaaaaa
            }
        })
    }

}