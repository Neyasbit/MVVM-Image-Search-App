package com.example.mvvmimagesearchapp.ui.gallery

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.mvvmimagesearchapp.data.repository.UnsplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(private val repository: UnsplashRepository) : ViewModel() {

    companion object {
        private const val DEFAULT_QUERY = "cats"
    }
    private val currentQuery = MutableLiveData(DEFAULT_QUERY)

    val photos = currentQuery.switchMap { query ->
        Log.e("ASD", ": ${repository.getSearchResult("cats").value}", )
        repository.getSearchResult(query).cachedIn(viewModelScope)
    }
    fun searchPhotos(query: String) {

    }
}