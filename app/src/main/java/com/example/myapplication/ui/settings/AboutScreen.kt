package com.example.myapplication.ui.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AboutScreen() {
    Column(Modifier.padding(16.dp)) {
        Text("About", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(20.dp))

        Text("CrossBorder Commuter App")
        Text("Version 1.0")
        Spacer(Modifier.height(10.dp))
        Text("Developer: James")
        Spacer(Modifier.height(20.dp))
        Text("This app helps cross-border commuters check ports, transport routes, and guides.")
    }
}
