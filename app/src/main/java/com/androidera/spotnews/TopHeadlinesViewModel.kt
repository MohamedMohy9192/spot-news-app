package com.androidera.spotnews

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.androidera.spotnews.model.NewsResponse
import kotlinx.coroutines.launch

class TopHeadlinesViewModel(
    private val repository: NewsRepository
) : ViewModel() {
    private val _topHeadlinesNews: MutableLiveData<NewsResponse> = MutableLiveData()
    val topHeadlinesNews = _topHeadlinesNews

    init {
        getTopHeadlinesNews()
    }

    private fun getTopHeadlinesNews() = viewModelScope.launch {
        try {
            _topHeadlinesNews.value = repository.topHeadlinesNews()
        } catch (exception: Exception) {

        }
    }

}


class ViewModelFactory(
    private val repository: NewsRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(TopHeadlinesViewModel::class.java)) {
            return TopHeadlinesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }


}