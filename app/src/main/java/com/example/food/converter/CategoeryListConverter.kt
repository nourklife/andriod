package com.example.food.converter

import androidx.room.TypeConverter
import com.example.food.entites.Categories_item
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CategoeryListConverter {


    /** ListCategories_item type converter */

    val gson = Gson()

    @TypeConverter
    fun fromCatogeryListToGson(categorey: List<Categories_item>): String? {
        if (categorey == null) {
            return null
        } else {
            val gson = Gson()
            val type = object : TypeToken<Categories_item>() {

            }.type
            return gson.toJson(categorey, type)
        }

    }

    @TypeConverter
    fun fromGsontToCategoryList(categoryString: String): List<Categories_item>? {
        if (categoryString == null) {
            return (null)
        } else {
            val gson = Gson()
            val type = object : TypeToken<Categories_item>() {


            }.type
            return gson.fromJson(categoryString, type)
        }
    }
}
