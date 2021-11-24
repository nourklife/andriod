package com.example.food.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codingwithme.recipeapp.adapter.SubCategoryAdapter
import com.example.food.R
import com.example.food.adpter.MainCategoryAdapter
import com.example.food.database.RecipeDatabase
import com.example.food.entites.Categories_item
import com.example.food.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    lateinit var rvMain: RecyclerView
    lateinit var rvsub: RecyclerView
    lateinit var viewModel:MainViewModel

    var arMiainCatogery = ArrayList<Categories_item>()
    var arsubCatogery = ArrayList<Categories_item>()
    var mainCatogeryAdapter = MainCategoryAdapter()
    var subCatogeryAdpter = SubCategoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        rvsub = findViewById(R.id.rv_sub_category)
        viewModel=ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.getRecipe()
        viewModel.recipeRsponse.observe(this, Observer {
            mainCatogeryAdapter.setData(it.categorieitems)
        })

        setUpRecycleView()
    }

    fun setUpRecycleView(){
        rvMain = findViewById(R.id.rv_main_category)
        rvMain.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity,LinearLayoutManager.HORIZONTAL,false)
            adapter = mainCatogeryAdapter
        }

    }

}
