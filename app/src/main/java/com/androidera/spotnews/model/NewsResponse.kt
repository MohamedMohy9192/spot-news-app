package com.androidera.spotnews.model

import com.androidera.spotnews.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)