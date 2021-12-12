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
import com.example.food.retropfitmodel.CategoryItem

class MainCategoryAdapter(val context: Activity) :
    RecyclerView.Adapter<MainCategoryAdapter.RecipeViewHolder>() {

    private var arrMainCategory = emptyList<CategoryItem>()
    var listener:MainCategoryAdapter.onItemClickListener?= null

    class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {

        return RecipeViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_rv_main_category, parent, false)
        )
    }


    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val currentPosition = arrMainCategory[position]
        val image = holder.itemView.findViewById<ImageView>(R.id.main_dish_img)
        holder.itemView.findViewById<TextView>(R.id.main_dish_name).text = currentPosition.strCategory
        holder.itemView.rootView.setOnClickListener{
            listener!!.onClicked(arrMainCategory[position].strCategory)
        }

        Glide
            .with(context)
            .load(arrMainCategory[position].strCategoryThumb)
            .centerCrop()
            .placeholder(R.drawable.cat_img)
            .into(image)

    }
    interface onItemClickListener{
        fun onClicked(categoryName:String)
    }
    override fun getItemCount(): Int {
        return arrMainCategory.size
    }

    fun setData(arrData: List<CategoryItem>) {
        arrMainCategory = arrData
    }
    fun setClickListener(listener1: MainCategoryAdapter.onItemClickListener){
        listener = listener1
    }

}

