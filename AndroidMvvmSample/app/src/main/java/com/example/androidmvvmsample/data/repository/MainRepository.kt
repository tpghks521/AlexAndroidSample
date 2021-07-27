package com.example.androidmvvmsample.data.repository

import com.example.androidmvvmsample.ResultWrapper
import com.example.androidmvvmsample.api.AppService
import com.example.androidmvvmsample.data.BaseRepository
import com.example.androidmvvmsample.data.KakaoImageList
import com.example.androidmvvmsample.safeApiCall
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: AppService) : BaseRepository {


    suspend fun requestImageList(): ResultWrapper<KakaoImageList> {
        val response = safeApiCall {
            apiService.searchImage("query", 0, 10)
        }
        return response
    }
}