package org.example.project.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import okio.Path.Companion.toPath


fun createDataStore(producePath: () -> String): DataStore<Preferences> {
    return PreferenceDataStoreFactory.createWithPath(
        produceFile = { producePath().toPath() }
    )
}

internal const val DATA_STORE_FILE_NAME = "prefs.preferences_pb"
internal const val DATA_STORE_PROFILE = "profile_key"

object PreferencesKeys {
    val profileKeys = stringPreferencesKey(DATA_STORE_PROFILE)
}