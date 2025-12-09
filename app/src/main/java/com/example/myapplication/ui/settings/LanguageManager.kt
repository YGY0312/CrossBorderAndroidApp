package com.example.myapplication.ui.settings

object LanguageManager {

    enum class AppLanguage { ENGLISH, CHINESE }

    var current = AppLanguage.ENGLISH

    fun t(key: String): String {
        return when (current) {
            AppLanguage.ENGLISH -> en[key] ?: key
            AppLanguage.CHINESE -> zh[key] ?: key
        }
    }

    private val en = mapOf(
        "home" to "Home",
        "routes" to "Routes",
        "guide" to "Guide",
        "settings" to "Settings",
        "about" to "About",

        "language" to "Language",
        "dark_mode" to "Dark Mode",

        "cross_border_commuter" to "CrossBorder Commuter",
        "common_border" to "Common Border Checkpoints",
        "current_weather" to "Current Weather",
        "shenzhen_weather" to "Shenzhen",
        "hong_kong_weather" to "Hong Kong",
        "temperature" to "Temperature",
        "wind_speed" to "Wind speed",
        "weather_loading" to "Loading weather..."
    )

    private val zh = mapOf(
        "home" to "首页",
        "routes" to "路线",
        "guide" to "指南",
        "settings" to "设置",
        "about" to "关于",

        "language" to "语言",
        "dark_mode" to "深色模式",

        "cross_border_commuter" to "跨境通勤助手",
        "common_border" to "常用口岸",
        "current_weather" to "当前天气",
        "shenzhen_weather" to "深圳",
        "hong_kong_weather" to "香港",
        "temperature" to "气温",
        "wind_speed" to "风速",
        "weather_loading" to "正在加载天气..."
    )
}
