package com.example.androidmvvmsample.common

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HomeParameter(val id: Int) : Parcelable

@Parcelize
data class MainParameter(val id: Int) : Parcelable

