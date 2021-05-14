package com.example.androidmvvmsample.api

import retrofit2.http.GET

interface Search {


    @GET("v1/search/blog")
    fun requestSearch()
}