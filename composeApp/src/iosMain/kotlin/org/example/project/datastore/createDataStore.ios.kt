@file:OptIn(ExperimentalForeignApi::class)

package org.example.project.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask
import org.example.project.data.datastore.DATA_STORE_FILE_NAME

fun createDataStore(): DataStore<Preferences> {
    return org.example.project.data.datastore.createDataStore {
        val directory = NSFileManager.defaultManager.URLForDirectory(
            directory = NSDocumentDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            create = false,
            error = null
        )
        requireNotNull(directory).path + "/$DATA_STORE_FILE_NAME"
    }
}