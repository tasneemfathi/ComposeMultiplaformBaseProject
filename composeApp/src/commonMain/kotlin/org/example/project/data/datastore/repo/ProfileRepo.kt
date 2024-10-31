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

class ProfileRepo(val dataStore : DataStore<Preferences>){

    val userProfile : Flow<Profile>
        get() = dataStore.data.map {
            try {
                Json.decodeFromString(it[PreferencesKeys.profileKeys] ?: "{}")
            }catch (e: Exception){
                e.printStackTrace()
                Profile()
            }
        }

    suspend fun updateUserProfile(profile:Profile){
        dataStore.edit {
            it[PreferencesKeys.profileKeys] = Json.encodeToString(profile)
        }
    }

}