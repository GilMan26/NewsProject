package com.example.newsproject.ui.main.sources

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsproject.NewsService.NewsService
import com.example.newsproject.Retrofit.RetrofitClient
import com.example.newsproject.models.Source
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SourcesViewModel : ViewModel() {

    val API_KEY = "4570994136d54cda942732435adaaf41"
    var sources = MutableLiveData<ArrayList<Source>>()
    lateinit var newsService : NewsService

    fun getSources(){
        newsService = RetrofitClient.getRetrofitInstance()
        CoroutineScope(Dispatchers.IO).launch {
            var response = newsService.getSources("", "", API_KEY )
            withContext(Dispatchers.Main){
                sources.value = response.body()?.sources as ArrayList<Source>?
            }

        }
    }
}
