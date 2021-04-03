package com.example.mvvmimagesearchapp.ui.gallery

import androidx.lifecycle.ViewModel
import com.example.mvvmimagesearchapp.data.repository.UnasplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor (private val repository: UnasplashRepository) : ViewModel() {
}