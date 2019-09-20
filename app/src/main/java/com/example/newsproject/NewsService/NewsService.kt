package com.example.newsproject.NewsService

import com.example.newsproject.models.News
import com.example.newsproject.models.Source
import com.example.newsproject.models.response.EverythingResponse
import com.example.newsproject.models.response.SourcesResponse
import com.example.newsproject.models.response.TopHeadlinesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("everything")
    suspend fun getEverything(@Query("country") country :String,
                              @Query("sources") sources : String,
                              @Query("category") category : String,
                              @Query("q") query : String,
                              @Query("apiKey") apiKey : String) : Response<EverythingResponse>

    @GET("top-headlines")
    suspend fun getTopHeadlines(@Query("country") country :String,
                                @Query("sources") sources : String,
                                @Query("category") category : String,
                                @Query("q") query : String,
                                @Query("apiKey") apiKey : String) : Response<TopHeadlinesResponse>

    @GET("sources")
    suspend fun getSources(@Query("country") country: String,
                           @Query("language") language : String,
                           @Query("apiKey") apiKey: String) : Response<SourcesResponse>

}