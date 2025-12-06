package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.navigation.AppNavGraph
import com.example.myapplication.ui.navigation.BottomBar
import com.example.myapplication.ui.settings.SettingsViewModel
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {

    private val settingsViewModel: SettingsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isDarkMode = settingsViewModel.isDarkMode
            val currentLanguage = settingsViewModel.language

            MyApplicationTheme(darkTheme = isDarkMode) {
                val navController = rememberNavController()

                Scaffold(
                    bottomBar = {
                        BottomBar(
                            navController = navController,
                            currentLanguage = currentLanguage
                        )
                    }
                ) { innerPadding ->
                    Surface(
                        modifier = Modifier.padding(innerPadding),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        AppNavGraph(
                            navController = navController,
                            settingsViewModel = settingsViewModel
                        )
                    }
                }
            }
        }
    }
}
