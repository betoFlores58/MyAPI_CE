package com.example.myapi

import com.example.myapi.model.UsersItem
import retrofit2.Call
import retrofit2.http.GET

interface UsersApi {

    @GET("todos")
    fun getUsersItems(): Call<List<UsersItem>>
}
