package com.example.food.viewmodels

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import com.example.food.entites.Meal
import com.example.food.repository.Repository
import com.example.food.retropfitmodel.Catogries
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


    fun getRecipe() {
        viewModelScope.launch {
            handleResponse()
        }
    }
    fun getMeal(mealid: String) {
        viewModelScope.launch {
            handleMealResponse(mealid)
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
                Log.v("ANy", "${it.body()}")
            } else {
                Log.v("ANy", "${it.message()}")
                Toast.makeText(context, "error: ${it.code()}", Toast.LENGTH_LONG).show()
            }
        }

    }


}