package com.madhram.hramtsovtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.madhram.hramtsovtest.data.api.ApiHelper
import com.madhram.hramtsovtest.data.api.ApiServiceImp
import com.madhram.hramtsovtest.data.model.CompanyResponse
import com.madhram.hramtsovtest.ui.base.ViewModelFactory
import com.madhram.hramtsovtest.ui.main.adapter.MainAdapter
import com.madhram.hramtsovtest.ui.main.viewmodel.MainViewModel
import com.madhram.hramtsovtest.utils.Status
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var MainViewModel: MainViewModel
    private lateinit var adapter: MainAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUi()
        setupViewModel()
        setupObserver()

    }

    fun setupUi(){
        rwcompanies.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        rwcompanies.addItemDecoration(
            DividerItemDecoration(
                rwcompanies.context,
                (rwcompanies.layoutManager as LinearLayoutManager).orientation
            )
        )
        rwcompanies.adapter = adapter
    }

    fun setupObserver(){
        MainViewModel.getCompanies().observe(this, Observer {
            when(it.status){
                Status.SUCCESS -> {
                    progressbar.visibility = View.GONE
                    it.data?.let {companies ->
                        renderList(companies)
                        rwcompanies.visibility = View.VISIBLE
                    }
                }
                Status.LOADING -> {
                    progressbar.visibility = View.VISIBLE
                    rwcompanies.visibility = View.GONE
                }
                Status.ERROR -> {
                    progressbar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    fun renderList(companies: List<CompanyResponse>){
        adapter.addData(companies)
        adapter.notifyDataSetChanged()
    }


    fun setupViewModel(){
        MainViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(ApiServiceImp()))
        ).get(MainViewModel::class.java)
    }
}