package org.example.project

import androidx.lifecycle.ViewModel

import kotlinx.coroutines.flow.Flow
import org.example.project.data.datastore.repo.AppConfigRepo

class AppViewModel(appConfigRepo:  AppConfigRepo):
    ViewModel(){
    val appLang : Flow<String> = appConfigRepo.appLang

}