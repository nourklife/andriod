package com.example.food.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.food.entites.converter.MealListConverter
import com.example.food.Dao.RecipeDao
import com.example.food.entites.Categories
import com.example.food.entites.Categories_item
import com.example.food.entites.MealsItems
import com.example.food.entites.Recipes
import com.example.food.entites.converter.CategoeryListConverter
import kotlinx.coroutines.CoroutineScope

@Database(
    entities = [Recipes::class, Categories_item::class, Categories::class,MealsItems::class],
    version = 2, exportSchema = false
)
@TypeConverters(CategoeryListConverter::class, MealListConverter::class)
abstract class RecipeDatabase : RoomDatabase() {

    abstract fun recipeDao(): RecipeDao


}