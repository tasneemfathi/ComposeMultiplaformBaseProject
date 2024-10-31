package org.example.project.navigation.start

import androidx.navigation.NavController
import org.example.project.navigation.Destinations


fun NavController.navigateToAddNew(){
    navigate(Destinations.AddNewScreen.toString())
}