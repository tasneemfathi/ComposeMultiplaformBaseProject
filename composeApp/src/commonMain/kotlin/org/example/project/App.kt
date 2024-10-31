package org.example.project


import androidx.compose.runtime.*
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.setSingletonImageLoaderFactory
import com.mmk.kmpnotifier.notification.NotifierManager
import com.mmk.kmpnotifier.notification.PayloadData
import org.example.project.navigation.NavigationHost
import org.example.project.ui.theme.MyAppTheme
import org.example.project.utils.getAsyncImageLoader
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext


@OptIn(ExperimentalCoilApi::class)
@Composable
@Preview
fun App() {
    MyAppTheme {
        setSingletonImageLoaderFactory { context ->
            getAsyncImageLoader(context)
        }
        KoinContext {
            bindNotificationsManagers()

            NavigationHost()
        }
    }
}

private fun bindNotificationsManagers() {
    NotifierManager.addListener(object : NotifierManager.Listener {
        override fun onNewToken(token: String) {
            println("onNewToken: $token") //Update user token in the server if needed
        }
    })
    NotifierManager.addListener(object : NotifierManager.Listener {
        override fun onPushNotification(title: String?, body: String?) {
            println("Push Notification notification title: $title")
        }
    })
    NotifierManager.addListener(object : NotifierManager.Listener {
        override fun onPayloadData(data: PayloadData) {
            println("Push Notification payloadData: $data") //PayloadData is just typeAlias for Map<String,*>.
        }
    })
}