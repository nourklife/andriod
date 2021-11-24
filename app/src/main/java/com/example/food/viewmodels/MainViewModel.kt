package com.example.food.viewmodels

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import com.example.food.database.RecipeDatabase
import com.example.food.entites.Categories
import com.example.food.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
    val context: Application
) : AndroidViewModel(context) {

    private val mutable: MutableLiveData<Categories> = MutableLiveData()
    val recipeRsponse: LiveData<Categories> get() = mutable


    fun getRecipe() {
        viewModelScope.launch {
            handleResponce()
        }
    }

    private suspend fun handleResponce() {
        repository.getRecipe().let {
            if (it.isSuccessful) {
                mutable.postValue(it.body())
                Log.v("ANy", "${it.body()}")
            } else {
                Log.v("ANy", "$it.code()")
                Toast.makeText(context, "error: ${it.code()}", Toast.LENGTH_LONG).show()
            }
        }
    }







}