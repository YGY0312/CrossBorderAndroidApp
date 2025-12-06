package com.example.myapplication.model

data class BorderCheckpoint(
    val name: String,
    val cityPair: String,
    val note: String,
    val openHours: String,
    val transport: List<String>
)
