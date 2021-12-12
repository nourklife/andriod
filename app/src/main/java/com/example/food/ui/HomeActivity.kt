package com.example.food.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.food.R
import com.example.food.adpter.MainCategoryAdapter
import com.example.food.adpter.SubCategoryAdapter
import com.example.food.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home.*

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    lateinit var viewModel:MainViewModel
    var mainCatogeryAdapter = MainCategoryAdapter(this)
    var subCatogeryAdapter = SubCategoryAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        viewModel=ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getRecipe()
        viewModel.recipeResponse.observe(this, Observer {
            mainCatogeryAdapter.setData(it.categories)
        })



        viewModel.mealResponse.observe(this, Observer {
            subCatogeryAdapter.setData(it.meals)

        })
        setUpMainRecycleView()
        setUpSubReucucleview()
    }

    fun setUpMainRecycleView(){
        val rvMain = findViewById<RecyclerView>(R.id.rv_main_category)
        val onCLicked  = object :MainCategoryAdapter.onItemClickListener{
            override fun onClicked(categoryName: String) {
                viewModel.getMeal(categoryName)

            }

        }
        mainCatogeryAdapter.setClickListener(onCLicked)
        rvMain.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity,LinearLayoutManager.HORIZONTAL,false)
            adapter = mainCatogeryAdapter
        }


    }
    fun setUpSubReucucleview(){
        val rvsub=findViewById<RecyclerView>(R.id.rv_sub_category)
        rvsub.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity,LinearLayoutManager.HORIZONTAL,false)
            adapter = subCatogeryAdapter
        }


    }


}
