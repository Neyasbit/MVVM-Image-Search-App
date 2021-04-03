package com.example.mvvmimagesearchapp.di

import com.example.mvvmimagesearchapp.api.UnsplashApi
import com.example.mvvmimagesearchapp.data.repository.UnsplashRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
 class ViewModelGalleryModule {
    @Provides
    @ViewModelScoped
    fun provideRepository(unSplashApi: UnsplashApi) = UnsplashRepository(unSplashApi)
}