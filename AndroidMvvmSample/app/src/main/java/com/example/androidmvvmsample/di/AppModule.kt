package com.example.androidmvvmsample.di

import android.content.Context
import com.example.androidmvvmsample.api.ApiService
import com.example.androidmvvmsample.data.AppDatabase
import com.example.androidmvvmsample.data.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
class AppModule {


    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    @Singleton
    fun provideMainRepository(): MainRepository {
        return MainRepository()
    }

}