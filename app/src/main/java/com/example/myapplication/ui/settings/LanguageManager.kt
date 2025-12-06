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
        "common_border" to "Common Border Checkpoints"
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
        "common_border" to "常用口岸"
    )
}
