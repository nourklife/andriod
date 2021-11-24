package com.example.food.adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.food.R
import com.example.food.entites.Categories_item
import com.example.food.entites.Recipes
import kotlinx.android.synthetic.main.item_rv_main_category.view.*
import kotlinx.android.synthetic.main.item_rv_sub_category.view.*
import kotlinx.android.synthetic.main.item_rv_sub_category.view.tv_dish_name

class MainCategoryAdapter:RecyclerView.Adapter<MainCategoryAdapter.recipeViewHolder>() {
    var ctx:Context?=null
    var airmanCategory= emptyList<Categories_item>()

    class recipeViewHolder(view:View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): recipeViewHolder {
        ctx=parent.context
     return recipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv_main_category,parent,false))
    }
    fun setData(arrData:List<Categories_item>){
        airmanCategory=arrData
    }


    override fun onBindViewHolder(holder: recipeViewHolder, position: Int) {
         holder.itemView.tv_dish_name.text=airmanCategory[position].strCategory
        Glide.with(ctx!!).load(airmanCategory[position].strCategoryThumb).into(holder.itemView.main_img_dish)
    }

    override fun getItemCount(): Int {
      return airmanCategory.size
    }
}