package com.androidera.spotnews

import android.app.Application
import com.androidera.spotnews.network.NewsApiService
import com.androidera.spotnews.network.retrofit

class NewsApplication : Application() {

    private val service: NewsApiService by lazy { retrofit.create(NewsApiService::class.java) }
    val repository: NewsRepository by lazy { NewsRepository(service) }
}