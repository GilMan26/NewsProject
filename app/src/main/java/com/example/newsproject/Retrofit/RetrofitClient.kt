package com.example.newsproject.Retrofit

import com.example.newsproject.NewsService.NewsService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val BASE_URL = "https://newsapi.org/v2/"

    fun getRetrofitInstance(): NewsService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(NewsService::class.java)
    }


}