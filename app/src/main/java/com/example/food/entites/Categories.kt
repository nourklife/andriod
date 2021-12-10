package com.example.food.entites


import androidx.room.*
import com.example.food.converter.CategoeryListConverter
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName ="Categories" )
data class Categories (
	@PrimaryKey(autoGenerate = true)
	var id: Int,
	@Expose
	@ColumnInfo(name="categories")
	@SerializedName("categories")
//	@TypeConverters(CategoeryListConverter::class)
	val categorieitems : List<Categories_item>
) {

}