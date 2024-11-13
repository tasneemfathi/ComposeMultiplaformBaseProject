package org.example.project.utils

import androidx.navigation.NavHostController
import com.mmk.kmpnotifier.notification.NotifierManager
import com.mmk.kmpnotifier.notification.PayloadData


fun handleInAppLaunchedNotificationActions(navController: NavHostController){
    NotifierManager.addListener(object : NotifierManager.Listener {
        override fun onPayloadData(data: PayloadData) {
            println("Push Notification payloadData: $data") //PayloadData is just typeAlias for Map<String,*>.
        }

        override fun onNewToken(token: String) {
            println("onNewToken: $token") //Update user token in the server if needed
        }
    })
}
