package com.example.mvvmimagesearchapp.api

import com.example.mvvmimagesearchapp.data.models.UnsplashPhoto

data class UnsplashResponse(
    val results: List<UnsplashPhoto>
)
