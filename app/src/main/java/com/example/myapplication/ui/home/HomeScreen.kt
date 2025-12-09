package com.example.myapplication.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.MockData
import com.example.myapplication.model.BorderCheckpoint
import com.example.myapplication.model.WeatherResponse
import com.example.myapplication.ui.settings.LanguageManager
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(weatherViewModel: WeatherViewModel = viewModel()) {
    val szWeather by weatherViewModel.szWeather.collectAsState()
    val hkWeather by weatherViewModel.hkWeather.collectAsState()

    LaunchedEffect(Unit) {
        weatherViewModel.loadWeather()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = LanguageManager.t("cross_border_commuter"),
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        WeatherSection(szWeather = szWeather, hkWeather = hkWeather)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = LanguageManager.t("common_border"),
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(MockData.borderCheckpoints) { checkpoint ->
                BorderCheckpointCard(checkpoint)
            }
        }
    }
}

@Composable
private fun WeatherSection(
    szWeather: WeatherResponse?,
    hkWeather: WeatherResponse?
) {
    Text(
        text = LanguageManager.t("current_weather"),
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.SemiBold
    )
    Spacer(modifier = Modifier.height(8.dp))
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        WeatherCard(
            title = LanguageManager.t("shenzhen_weather"),
            weather = szWeather
        )
        WeatherCard(
            title = LanguageManager.t("hong_kong_weather"),
            weather = hkWeather
        )
    }
}

@Composable
private fun WeatherCard(title: String, weather: WeatherResponse?) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(4.dp))
            if (weather != null) {
                Text(
                    text = "${LanguageManager.t("temperature")}: ${weather.current_weather.temperature}℃",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${LanguageManager.t("wind_speed")}: ${weather.current_weather.windspeed} km/h",
                    style = MaterialTheme.typography.bodyMedium
                )
            } else {
                Text(
                    text = LanguageManager.t("weather_loading"),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
    Divider()
}

@Composable
fun BorderCheckpointCard(checkpoint: BorderCheckpoint) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = checkpoint.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = checkpoint.cityPair,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = checkpoint.note,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
