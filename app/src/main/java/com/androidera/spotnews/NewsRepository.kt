package com.androidera.spotnews

import com.androidera.spotnews.network.NewsApiService

class NewsRepository(
    private val service: NewsApiService
) {

    suspend fun topHeadlinesNews() = service.getHeadlinesNews()
}