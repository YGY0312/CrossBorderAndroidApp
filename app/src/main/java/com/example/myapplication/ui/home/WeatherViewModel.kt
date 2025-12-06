package com.example.myapplication.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.WeatherResponse
import com.example.myapplication.network.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    private val _szWeather = MutableStateFlow<WeatherResponse?>(null)
    val szWeather: StateFlow<WeatherResponse?> = _szWeather

    private val _hkWeather = MutableStateFlow<WeatherResponse?>(null)
    val hkWeather: StateFlow<WeatherResponse?> = _hkWeather

    fun loadWeather() {
        viewModelScope.launch {
            _szWeather.value = RetrofitClient.api.getWeather(22.55, 114.05)
            _hkWeather.value = RetrofitClient.api.getWeather(22.32, 114.17)
        }
    }
}
