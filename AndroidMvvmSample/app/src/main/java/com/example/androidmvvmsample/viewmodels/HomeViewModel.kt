package com.example.androidmvvmsample.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidmvvmsample.common.BaseViewModel
import com.example.androidmvvmsample.data.KakaoImage
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel() {

    private val _kakaoImage = MutableLiveData<List<KakaoImage>>()
    val kakaoImage: LiveData<List<KakaoImage>>
        get() = _kakaoImage

}