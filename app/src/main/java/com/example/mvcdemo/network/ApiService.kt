package com.example.mvcdemo.network

import com.example.mvcdemo.model.BookModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("api/shorts")
    fun fetchData(): Call<BookModel>
}