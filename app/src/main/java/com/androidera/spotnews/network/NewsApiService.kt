package com.androidera.spotnews.network

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsApiService {
    @Headers("X-Api-Key: $NEWS_API_KEY")
    @GET("/v2/top-headlines")
    suspend fun getHeadlinesNews(
        @Query("country") country: String = "us",
        @Query("pageSize") numberOfResultPerPage: Int = 20,
        @Query("page") pageNumber: Int = 1
    ): NewsResponse
}