package com.example.myapplication.data

import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

val Context.languageDataStore by preferencesDataStore(name = "language_settings")

object LanguagePreferences {
    val LANGUAGE_KEY = stringPreferencesKey("app_language")
}
