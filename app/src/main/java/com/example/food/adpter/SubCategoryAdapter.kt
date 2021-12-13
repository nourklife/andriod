package com.example.food.adpter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.food.R
import com.example.food.retropfitmodel.MealItem

class SubCategoryAdapter(val context: Activity) :
    RecyclerView.Adapter<SubCategoryAdapter.RecipeViewHolder>() {



    var arrSubCategory = emptyList<MealItem>()
    var listener: SubCategoryAdapter.onItemClickListener?=null

    interface onItemClickListener {
        fun onClicked(id:String)


    }

    class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    fun setData(arrData: List<MealItem>) {
        arrSubCategory = arrData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {

        return RecipeViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_rv_sub_category, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return arrSubCategory.size
    }

    fun setOnItemclickListiner(listener1:SubCategoryAdapter.onItemClickListener) {
        listener = listener1
    }


    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val currentPosition = arrSubCategory[position]
        val image = holder.itemView.findViewById<ImageView>(R.id.img_dish)
        holder.itemView.rootView.setOnClickListener {
         listener!!.onClicked(currentPosition.idMeal)
        }
        holder.itemView.findViewById<TextView>(R.id.tv_dish_name).text = currentPosition.strMeal
        Glide
            .with(context)
            .load(currentPosition.strMealThumb)
            .centerCrop()
            .placeholder(R.drawable.cat_img)
            .into(image)


    }



}