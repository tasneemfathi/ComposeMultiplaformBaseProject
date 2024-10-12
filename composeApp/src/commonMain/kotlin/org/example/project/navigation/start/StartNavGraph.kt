package org.example.project.navigation.start


import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import org.example.project.navigation.Destinations
import org.example.project.scence.start.StartScreen
import org.example.project.scence.start.StartViewModel
import org.koin.compose.viewmodel.koinViewModel

fun NavGraphBuilder.startNavigationHost(navController: NavHostController) {

    composable(route = Destinations.StartScreen.toString()){
        val viewModel = koinViewModel<StartViewModel>()
        StartScreen(viewModel = viewModel,navigateToDetails = navController::navigateToDetails)
    }
}

