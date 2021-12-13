package com.example.food.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.food.R
import com.example.food.viewmodels.MainViewModel
import com.makeramen.roundedimageview.RoundedImageView
import kotlinx.android.synthetic.main.activity_deatails.*

class DeatailsActivity : AppCompatActivity() {
    var youtubeLink = ""
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deatails)
        var image=findViewById<RoundedImageView>(R.id.imgItem)
        var tvCatogery=findViewById<TextView>(R.id.tvCategory)
        var id=intent.getStringExtra("id")
        btnYoutube.setOnClickListener {
            val uri = Uri.parse(youtubeLink)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getMealDetails(id!!)
        viewModel.mealdetails.observe(this, Observer { response->
            Glide.with(this).load(response.meals[0].strMealThumb).into(image)
            tvCatogery.text = response.meals[0].strMeal
            var ingredient = "${response.meals[0].strIngredient1}      ${response.meals[0].strMeasure1}\n" +
                    "${response.meals[0].strIngredient2}      ${response.meals[0].strMeasure2}\n" +
                    "${response.meals[0].strIngredient6}      ${response.meals[0].strMeasure6}\n" +
                    "${response.meals[0].strIngredient7}      ${response.meals[0].strMeasure7}\n" +
                    "${response.meals[0].strIngredient8}      ${response.meals[0].strMeasure8}\n" +
                    "${response.meals[0].strIngredient9}      ${response.meals[0].strMeasure9}\n" +
                    "${response.meals[0].strIngredient10}      ${response.meals[0].strMeasure10}\n" +
                    "${response.meals[0].strIngredient11}      ${response.meals[0].strMeasure11}\n" +
                    "${response.meals[0].strIngredient12}      ${response.meals[0].strMeasure12}\n" +
                    "${response.meals[0].strIngredient13}      ${response.meals[0].strMeasure13}\n" +
                    "${response.meals[0].strIngredient14}      ${response.meals[0].strMeasure14}\n" +
                    "${response.meals[0].strIngredient16}      ${response.meals[0].strMeasure15}\n" +
                    "${response.meals[0].strIngredient17}      ${response.meals[0].strMeasure16}\n" +
                    "${response.meals[0].strIngredient18}      ${response.meals[0].strMeasure17}\n" +
                    "${response.meals[0].strIngredient19}      ${response.meals[0].strMeasure18}\n" +
                    "${response.meals[0].strIngredient3}      ${response.meals[0].strMeasure19}\n" +
                    "${response.meals[0].strIngredient20}      ${response.meals[0].strMeasure20}\n"
            tvIngredients.text = ingredient
            tvInstructions.text = response.meals[0].strInstructions
            if (response.meals[0].strYoutube != null){
                youtubeLink = response.meals[0].strYoutube
            }else{
                btnYoutube.visibility = View.GONE
            }

        })

    }
}