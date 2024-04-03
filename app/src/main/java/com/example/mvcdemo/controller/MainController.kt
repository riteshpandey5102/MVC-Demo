package com.example.mvcdemo.controller

import android.content.Intent
import android.os.Bundle
import com.example.mvcdemo.model.DataItem
import com.example.mvcdemo.model.MainModel
import com.example.mvcdemo.view.DetailActivity
import com.example.mvcdemo.view.MainActivity

class MainController {
    private lateinit var mainView: MainActivity
    private lateinit var mainModel: MainModel

    infix fun hasView(mainActivity: MainActivity) {
        this.mainView = mainActivity
    }
    infix fun hasModel(mainModel: MainModel) {
        this.mainModel = mainModel
    }

    fun fetchData() {
        mainView.showProgressBar()
        mainModel.fetchData()
    }

    infix fun doWhenClick(item: DataItem) {
        val intent = Intent(mainView, DetailActivity::class.java)
        intent.putExtra(DetailActivity.Constants.TITLE, item.title)
        intent.putExtra(DetailActivity.Constants.TYPE, item.type)
        intent.putExtra(DetailActivity.Constants.YEAR, item.year.toString())
        mainView.startActivity(intent)
    }

    fun doWhenResultIsReady() {
        mainView.hideProgressBar()
        mainView.showResult()
    }

    fun doWhenThereIsErrorFetchingTheResult() {
        mainView.hideProgressBar()
        mainView.showError()
    }

}