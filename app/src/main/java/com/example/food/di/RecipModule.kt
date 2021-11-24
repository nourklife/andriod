package com.example.food.di


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.food.api.GetDataServices
@InstallIn(SingletonComponent::class)
@Module
object RecipModule {


    @Provides
    @Singleton
    fun provideGsonConverterFactory():GsonConverterFactory{
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory
    ):Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(gsonConverterFactory)
            .build()

    }

    @Provides
    @Singleton
    fun getDataServices (retrofit: Retrofit) : GetDataServices{
        return retrofit.create(GetDataServices::class.java)
    }
}