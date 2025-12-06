package com.example.myapplication.model

data class Route(
    val id: Int,
    val name: String,
    val from: String,
    val to: String,
    val duration: String,
    val transport: String,
    val steps: List<String>
)
