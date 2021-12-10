package com.example.food.di

import android.content.Context
import androidx.room.Room
import com.example.food.database.RecipeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent

import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object ModuelDB {


    @ViewModelScoped
    @Provides
    fun ProvideDB(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, RecipeDatabase::class.java,
        "RecipeDatabase"
    ).fallbackToDestructiveMigration()
        .allowMainThreadQueries()
        .build()


    @ViewModelScoped
    @Provides
    fun provideRecipeDao(recipeDatabase: RecipeDatabase) = recipeDatabase.recipeDao()


}