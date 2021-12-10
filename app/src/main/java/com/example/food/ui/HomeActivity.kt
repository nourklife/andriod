package com.example.food.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codingwithme.recipeapp.adapter.SubCategoryAdapter
import com.example.food.R
import com.example.food.adpter.MainCategoryAdapter
import com.example.food.entites.Categories_item
import com.example.food.retropfitmodel.Catogries
import com.example.food.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home.*

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    lateinit var viewModel:MainViewModel
    var mainCatogeryAdapter = MainCategoryAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        viewModel=ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getRecipe()
        viewModel.recipeResponse.observe(this, {
            mainCatogeryAdapter.setData(it.categories)
        })
        setUpRecycleView()
    }

    fun setUpRecycleView(){
        val rvMain = findViewById<RecyclerView>(R.id.rv_main_category)
        rvMain.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity,LinearLayoutManager.HORIZONTAL,false)
            adapter = mainCatogeryAdapter
        }

    }

}
