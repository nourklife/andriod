package com.example.food.adpter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.PointerIconCompat.load
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.food.R
import com.example.food.retropfitmodel.CatogeryItem
import kotlinx.android.synthetic.main.item_rv_main_category.view.*
import kotlinx.android.synthetic.main.item_rv_sub_category.view.tv_dish_name
import java.lang.System.load

class MainCategoryAdapter(val context: Activity) :
    RecyclerView.Adapter<MainCategoryAdapter.RecipeViewHolder>() {

    private var arrMainCategory = emptyList<CatogeryItem>()

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

        Glide
            .with(context)
            .load(arrMainCategory[position].strCategoryThumb)
            .centerCrop()
            .placeholder(R.drawable.cat_img)
            .into(image)
    }

    override fun getItemCount(): Int {
        return arrMainCategory.size
    }

    fun setData(arrData: List<CatogeryItem>) {
        arrMainCategory = arrData
    }
}