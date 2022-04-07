package com.androidera.spotnews.network

import com.androidera.spotnews.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


private const val BASE_URL = "https://newsapi.org"
private const val NEWS_API_KEY = BuildConfig.NEWS_API_KEY
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

interface NewsApiService {

    @Headers("X-Api-Key: $NEWS_API_KEY")
    @GET("/v2/top-headlines")
    suspend fun getHeadlinesNews(
        @Query("country") country: String = "us",
        @Query("pageSize") numberOfResultPerPage: Int = 20,
        @Query("page") pageNumber: Int = 1
    ): NewsResponse
}

object NewsApi {
    val service: NewsApiService by lazy {
        retrofit.create(NewsApiService::class.java)
    }
}