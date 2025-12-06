package com.example.myapplication.ui.settings

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SettingsViewModel : ViewModel() {


    var isDarkMode by mutableStateOf(false)
        private set


    var language by mutableStateOf("en")
        private set


    fun updateDarkMode(enabled: Boolean) {
        isDarkMode = enabled
    }

    fun updateLanguage(code: String) {
        language = code
    }
}
