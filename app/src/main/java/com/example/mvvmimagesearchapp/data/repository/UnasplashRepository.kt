package com.example.mvvmimagesearchapp.data.repository

import com.example.mvvmimagesearchapp.api.UnsplashApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnasplashRepository @Inject constructor(private val unsplashApi: UnsplashApi){
}