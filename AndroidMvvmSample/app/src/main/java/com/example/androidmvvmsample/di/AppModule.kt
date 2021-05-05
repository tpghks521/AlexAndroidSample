package com.example.androidmvvmsample.di

import android.content.Context
import com.example.androidmvvmsample.api.AppService
import com.example.androidmvvmsample.data.AppDatabase
import com.example.androidmvvmsample.data.repository.ImageRepository
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
    fun provideAppService(): AppService {
        return AppService.create()
    }

    @Provides
    @Singleton
    fun provideImageRepository(appService: AppService, appDatabase: AppDatabase): ImageRepository {
        return ImageRepository(appService, appDatabase)
    }

}