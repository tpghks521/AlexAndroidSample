package com.example.androidmvvmsample.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "appData")
data class AppData(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
