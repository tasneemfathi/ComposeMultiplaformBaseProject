package org.example.project.navigation.start


import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.example.project.navigation.Destinations
import org.example.project.scence.add.AddNewScreen
import org.example.project.scence.add.AddNewViewModel
import org.example.project.scence.users.StartScreen
import org.example.project.scence.users.UserViewModel
import org.koin.compose.viewmodel.koinViewModel


fun NavGraphBuilder.startNavigationHost(navController: NavHostController) {

    composable(route = Destinations.StartScreen.toString()){
        val viewModel = koinViewModel<UserViewModel>()
        StartScreen(viewModel = viewModel,navigateToAddNew = navController::navigateToAddNew)
    }
    composable(route = Destinations.AddNewScreen.toString()){
        val viewModel = koinViewModel<AddNewViewModel>()
        AddNewScreen(viewModel = viewModel, navUp = {navController.navigateUp()})
    }

}

