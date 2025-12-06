package com.example.myapplication.ui.settings

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State

class LanguageViewModel : ViewModel() {

    private val _language = mutableStateOf(LanguageManager.AppLanguage.ENGLISH)
    val language: State<LanguageManager.AppLanguage> = _language

    fun setLanguage(lang: LanguageManager.AppLanguage) {
        _language.value = lang
        LanguageManager.current = lang
    }
}
