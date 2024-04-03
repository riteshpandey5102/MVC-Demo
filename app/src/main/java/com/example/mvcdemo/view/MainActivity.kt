package com.example.mvcdemo.view

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.mvcdemo.R
import com.example.mvcdemo.adapter.Adapter
import com.example.mvcdemo.controller.MainController
import com.example.mvcdemo.model.DataItem
import com.example.mvcdemo.model.MainModel

class MainActivity : AppCompatActivity() {
    private lateinit var mainController: MainController
    private lateinit var mainModel: MainModel
    private lateinit var adapter: Adapter

    private lateinit var main_activity_recyclerView: RecyclerView
    private lateinit var main_activity_progress_bar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        loadView()
        mainController = MainController()
        mainModel = MainModel(mainController)
        mainController hasView this
        mainController hasModel mainModel
        mainController.fetchData()
    }

    private fun loadView() {
        setContentView(R.layout.activity_main)
        adapter = Adapter()
        main_activity_recyclerView = findViewById(R.id.main_activity_recyclerView)
        main_activity_progress_bar = findViewById(R.id.main_activity_progress_bar)
        main_activity_recyclerView.adapter = adapter
        adapter setItemClickMethod {
            mainController doWhenClick it
        }
        adapter.setItemShowMethod { fetchItemText(it) }
    }

    fun fetchItemText(it: DataItem): String {
        return "${it.year}: ${it.title}"
    }

    private fun updateRecyclerView(t: List<DataItem>) {
        adapter.updateList(t)
        adapter.notifyDataSetChanged()
    }

    fun showResult() {
        updateRecyclerView(mainModel.mList)
    }

    fun showError() {
        showToast(this, getString(R.string.error_getting_results, mainModel.errorMessege))
    }

    fun showProgressBar() {
        main_activity_progress_bar.visibility = View.VISIBLE
    }

    fun hideProgressBar() {
        main_activity_progress_bar.visibility = View.GONE
    }

    private fun showToast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

}