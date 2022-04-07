package com.androidera.spotnews

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TopHeadlinesViewModel(
    private val repository: NewsRepository
) {
}


class ViewModelFactory(
    private val repository: NewsRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(TopHeadlinesViewModel::class.java)) {
            return TopHeadlinesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}