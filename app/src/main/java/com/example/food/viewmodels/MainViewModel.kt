package com.example.food.viewmodels

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import com.example.food.entites.Meal
import com.example.food.repository.Repository
import com.example.food.retropfitmodel.Catogries
import com.example.food.retropfitmodel.MealRespnse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
    val context: Application
) : AndroidViewModel(context) {

    val recipeResponse: MutableLiveData<Catogries> = MutableLiveData()
    val mealResponse: MutableLiveData<com.example.food.retropfitmodel.Meal> = MutableLiveData()
    val mealdetails: MutableLiveData<MealRespnse> = MutableLiveData()



    fun getRecipe() {
        viewModelScope.launch {
            handleResponse()
        }
    }
    fun getMeal(catogeryName: String) {
        viewModelScope.launch {
            handleMealResponse(catogeryName)
        }
    }
    fun getMealDetails(id:String){
        viewModelScope.launch {
            handleMealDetails(id)
        }
    }

    private suspend fun handleResponse() {
        repository.getData().let {
            if (it.isSuccessful) {

                recipeResponse.postValue(it.body())
                Log.v("ANy", "${it.body()}")
            } else {
                Log.v("ANy", "${it.message()}")
                Toast.makeText(context, "error: ${it.code()}", Toast.LENGTH_LONG).show()
            }
        }

    }
    private suspend fun handleMealResponse(mealid:String) {
        repository.getMeal(mealid).let {
            if (it.isSuccessful) {
               mealResponse.postValue(it.body())
                Log.v("meal", "${it.body()}")
            } else {
                Log.v("meal", "${it.message()}")
                Toast.makeText(context, "error: ${it.code()}", Toast.LENGTH_LONG).show()
            }
        }

    }
    private suspend fun handleMealDetails(id:String){
        repository.getSpecificity(id).let {
            if(it.isSuccessful){
                mealdetails.postValue(it.body())
                Log.v("mealDetails", "${it.body()}")
            }else {
                Log.v("mealDetails", "${it.message()}")
                Toast.makeText(context, "error: ${it.code()}", Toast.LENGTH_LONG).show()
            }
        }
    }


}