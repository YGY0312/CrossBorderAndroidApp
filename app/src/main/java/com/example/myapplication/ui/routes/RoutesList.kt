package com.example.myapplication.ui.routes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.data.MockRouteData

@Composable
fun RoutesList(navController: NavController) {
    Column(modifier = Modifier.padding(16.dp)) {
        MockRouteData.routes.forEach { route ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable { navController.navigate("route/${route.id}") },
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = route.name,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "Duration: ${route.duration}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}
