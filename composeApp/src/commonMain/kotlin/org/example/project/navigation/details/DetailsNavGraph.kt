package org.example.project.navigation.details

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.example.project.navigation.Destinations
import org.example.project.scence.details.DetailsScreen

fun NavGraphBuilder.detailsNavigationHost(navController: NavController) {
    composable(route = Destinations.DetailsScreen.toString()){
        DetailsScreen()
    }
}