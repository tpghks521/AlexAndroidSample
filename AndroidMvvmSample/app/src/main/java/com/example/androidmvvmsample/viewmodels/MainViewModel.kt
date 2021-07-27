package com.example.androidmvvmsample.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.androidmvvmsample.common.BaseViewModel
import com.example.androidmvvmsample.data.KakaoImageList
import com.example.androidmvvmsample.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository) :
    BaseViewModel() {


    private val _imageList = MutableLiveData<KakaoImageList>()
    val imageList: LiveData<KakaoImageList> = _imageList

    fun requestImageList() = viewModelScope.launch {

        mainRepository.requestImageList()

    }
}