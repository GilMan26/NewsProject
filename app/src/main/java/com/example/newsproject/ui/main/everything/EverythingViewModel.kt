package com.example.newsproject.ui.main.everything

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsproject.NewsService.NewsService
import com.example.newsproject.Retrofit.RetrofitClient
import com.example.newsproject.models.News
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EverythingViewModel : ViewModel() {

    val API_KEY = "4570994136d54cda942732435adaaf41"
    var news = MutableLiveData<ArrayList<News>>()
    lateinit var newsService: NewsService

    fun getNews(query : String){
        newsService = RetrofitClient.getRetrofitInstance()
        CoroutineScope(Dispatchers.IO).launch {
            var response = newsService.getEverything("", "", "", query, API_KEY)
            withContext(Dispatchers.Main){
                news.value = response.body()?.articles as ArrayList<News>
            }
        }
    }

}
