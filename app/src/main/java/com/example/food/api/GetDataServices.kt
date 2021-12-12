package com.example.food.api


import com.example.food.retropfitmodel.Catogries
import com.example.food.retropfitmodel.Meal
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GetDataServices {

    @GET("categories.php")
    suspend fun getCatogery():Response<Catogries>
    @GET("filter.php")
    suspend fun getMeal(@Query("c" )category:String):Response<Meal>

}