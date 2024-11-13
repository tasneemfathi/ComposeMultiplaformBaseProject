package org.example.project.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.example.project.utils.handleInAppLaunchedNotificationActions


@Composable
fun NavigationHost(){
    val navController: NavHostController = rememberNavController()
    val startDestination: Destinations = Destinations.StartScreen
    handleInAppLaunchedNotificationActions(navController)
    Box(modifier = Modifier.fillMaxSize()){
        Scaffold(
            containerColor = Color.White) {
            Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background).padding(it)) {
                NavHostGraph(navController = navController, startDestination = startDestination)
            }
        }
    }

}

