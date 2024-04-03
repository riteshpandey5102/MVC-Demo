package com.example.mvcdemo.model

import com.example.mvcdemo.network.RetrofitClient
import com.example.mvcdemo.controller.MainController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainModel(val controller: MainController) {
    var mList = listOf<DataItem>()
    var errorMessege = ""
    fun fetchData() {
        val call : Call<BookModel> = RetrofitClient.getApiService().fetchData()
        call.enqueue(object : Callback<BookModel>{
            override fun onResponse(
                call: Call<BookModel>,
                response: Response<BookModel>
            ) {
                mList=response.body()!!.data
                controller.doWhenResultIsReady()
            }

            override fun onFailure(call: Call<BookModel>, t: Throwable) {
                errorMessege = t.message.toString()
                controller.doWhenThereIsErrorFetchingTheResult()
            }

        })
    }

}