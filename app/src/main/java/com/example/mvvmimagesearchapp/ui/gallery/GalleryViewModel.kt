package com.example.mvvmimagesearchapp.ui.gallery

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.mvvmimagesearchapp.data.repository.UnasplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor (private val repository: UnasplashRepository) : ViewModel() {
    companion object {
        private const val DEFAULT_QUERY = "cats"
    }
    private val currentQuery = MutableLiveData(DEFAULT_QUERY)

    val photos = currentQuery.switchMap { query ->
        repository.getSearchResult(query).cachedIn(viewModelScope)
    }
    fun searchPhotos(query: String) {

    }
}