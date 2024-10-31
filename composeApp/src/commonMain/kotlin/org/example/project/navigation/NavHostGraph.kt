package org.example.project.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import org.example.project.navigation.start.startNavigationHost


@Composable
fun NavHostGraph(navController: NavHostController,
                 startDestination: Destinations){

        NavHost(navController = navController, startDestination = startDestination.toString()){
             startNavigationHost(navController = navController)
        }
}
