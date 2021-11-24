package com.example.food.entites
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


@Entity(tableName = "Categories_item")
data class Categories_item(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @Expose
    @ColumnInfo(name = "idCategory")
    @SerializedName("idCategory")
    val idCategory: Int,
    @ColumnInfo(name = "strCategory")
    @Expose
    @SerializedName("strCategory")
    val strCategory: String,
    @ColumnInfo(name = "strCategoryThumb")
    @Expose
    @SerializedName("strCategoryThumb")
    val strCategoryThumb: String,
    @ColumnInfo(name = "strCategoryDescription")
    @Expose
    @SerializedName("strCategoryDescription")
    val strCategoryDescription: String
)