package com.example.food.database

import android.app.Application
import androidx.room.Room
import com.example.food.Dao.RecipeDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ModuelDB {
    @Singleton
    @Provides
    suspend fun ProvideDB(application: Application): RecipeDatabase {
        return Room.databaseBuilder(
            application, RecipeDatabase::class.java,
            "RecipeDatabase"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }
    @Singleton
    @Provides
    suspend fun provideRecipeDao(recipeDatabase: RecipeDatabase):RecipeDao{
        return recipeDatabase.recipeDao()

    }


}