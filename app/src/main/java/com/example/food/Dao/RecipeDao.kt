package com.example.food.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.food.entites.Categories_item
import com.example.food.entites.MealsItems


@Dao
interface RecipeDao {

    @Query("SELECT * FROM Categories_item ORDER BY id DESC")
    suspend fun getAllCategory() : List<Categories_item>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(categoryItems: kotlin.collections.List<com.example.food.entites.Categories_item>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeal(mealsItems: MealsItems?)
//هو كان فيه ايه في الكليه النهاردهوال
    @Query("DELETE FROM categories_item")
    suspend fun clearDb()

    @Query("SELECT * FROM MealItems WHERE categoryName = :categoryName ORDER BY id DESC")
    suspend fun getSpecificMealList(categoryName:String) : List<MealsItems>

}