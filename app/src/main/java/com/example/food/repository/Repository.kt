package com.example.food.repository

import com.example.food.Dao.RecipeDao
import com.example.food.api.GetDataServices
import com.example.food.retropfitmodel.Catogries
import com.example.food.retropfitmodel.Meal
import com.example.food.retropfitmodel.MealRespnse
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Response
import javax.inject.Inject


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
    suspend fun getMeal(categoryName:String):Response<Meal>{
        return  servicesData.getMeal(categoryName)
    }
    suspend fun getSpecificity(id:String):Response<MealRespnse>{
               return servicesData.getSpecificItem(id)
    }


}