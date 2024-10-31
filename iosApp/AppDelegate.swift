//
//  AppDelegate.swift
//  iosApp
//
//  Created by tasneem .. on 24/10/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import FirebaseCore
import FirebaseMessaging
import ComposeApp

class AppDelegate: NSObject, UIApplicationDelegate {

      func application(_ application: UIApplication,
                       didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil) -> Bool {

          FirebaseApp.configure() //important

          //By default showPushNotification value is true.
          //When set showPushNotification to false foreground push  notification will not be shown.
          //You can still get notification content using #onPushNotification listener method.
          NotifierManager.shared.initialize(configuration: NotificationPlatformConfigurationIos(
                showPushNotification: true,
                askNotificationPermissionOnStart: true,notificationSoundName:"")
          )

        return true
      }

      func application(_ application: UIApplication, didRegisterForRemoteNotificationsWithDeviceToken deviceToken: Data) {
            Messaging.messaging().apnsToken = deviceToken
      }

    func application(_ application: UIApplication, didReceiveRemoteNotification userInfo: [AnyHashable : Any]) async -> UIBackgroundFetchResult {
         NotifierManager.shared.onApplicationDidReceiveRemoteNotification(userInfo: userInfo)
         return UIBackgroundFetchResult.newData
    }


}
