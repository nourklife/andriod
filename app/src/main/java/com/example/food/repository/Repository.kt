package com.example.food.repository

import com.example.food.Dao.RecipeDao
import com.example.food.api.GetDataServices
import com.example.food.entites.Categories
import com.example.food.entites.Categories_item
import com.example.food.retropfitmodel.Catogries
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject
import javax.microedition.khronos.opengles.GL


@ViewModelScoped
class Repository @Inject constructor(
    private val servicesData: GetDataServices,
    private val recipeDao: RecipeDao
) {

    /** Remote Data Source*/
    // suspend fun getRecipe(): Response<Categories> {
    //   return servicesData.getCatogery()
    // }


    /** Local Data Source*/
    // suspend fun insertData(categories: Categories) {
    //recipeDao.insertCategory(categories.categorieitems)
    // }

    suspend fun getData(): Response<Catogries> {
        return servicesData.getCatogery()
    }


}