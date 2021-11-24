package com.example.food.api

import com.example.food.entites.Categories
import com.example.food.entites.Categories_item
import retrofit2.Response
import retrofit2.http.GET

 interface GetDataServices {

    @GET("categories.php")
    suspend fun getCatogery():Response<Categories>

}