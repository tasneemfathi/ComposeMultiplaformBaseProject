package org.example.project.data.datastore.repo


import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.example.project.data.datastore.PreferencesKeys
import org.example.project.data.model.profile.Profile

class AppConfigRepo(private val dataStore : DataStore<Preferences>) {
    val appLang: Flow<String>
        get() = dataStore.data.map { it[PreferencesKeys.langKeys] ?: "ar" }

    suspend fun updateAppLang(lang: String) {
        dataStore.edit {
            it[PreferencesKeys.langKeys] = lang
        }
    }
}
