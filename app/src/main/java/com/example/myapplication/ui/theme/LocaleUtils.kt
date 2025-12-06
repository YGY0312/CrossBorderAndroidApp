package com.example.myapplication.ui.theme

import android.content.Context
import android.content.res.Configuration
import java.util.Locale

fun applyLanguage(context: Context, lang: String): Context {
    val locale = when (lang) {
        "zh" -> Locale.SIMPLIFIED_CHINESE
        "hk" -> Locale.TRADITIONAL_CHINESE
        else -> Locale.ENGLISH
    }
    Locale.setDefault(locale)
    val config = Configuration(context.resources.configuration)
    config.setLocale(locale)
    return context.createConfigurationContext(config)
}
