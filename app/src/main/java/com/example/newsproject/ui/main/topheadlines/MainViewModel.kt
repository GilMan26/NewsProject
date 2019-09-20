package com.example.newsproject.ui.main.topheadlines

import android.content.res.Resources
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsproject.NewsService.NewsService
import com.example.newsproject.R
import com.example.newsproject.Retrofit.RetrofitClient
import com.example.newsproject.models.News
import com.example.newsproject.models.Source
import kotlinx.coroutines.*

class MainViewModel : ViewModel() {

    val API_KEY = "4570994136d54cda942732435adaaf41"
    var list = MutableLiveData<ArrayList<News>>()
    lateinit var newsService : NewsService

    fun getTopHeadlines() {
        newsService = RetrofitClient.getRetrofitInstance()
        CoroutineScope(Dispatchers.IO).launch {
            var response = newsService.getTopHeadlines("in", "","", "", API_KEY )
            withContext(Dispatchers.Main){
                list.value = response.body()?.articles as ArrayList<News>?
            }
        }
    }

}
