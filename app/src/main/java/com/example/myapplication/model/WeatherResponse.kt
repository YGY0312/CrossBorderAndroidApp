package com.example.myapplication.model

import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    val current_weather: CurrentWeather
)

@Serializable
data class CurrentWeather(
    val temperature: Double,
    val windspeed: Double,
    val weathercode: Int
)
