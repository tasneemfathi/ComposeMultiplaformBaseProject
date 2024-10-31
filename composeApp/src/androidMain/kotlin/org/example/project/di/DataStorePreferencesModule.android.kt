package org.example.project.di

import org.example.project.datastore.createDataStore
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

actual val DataStorePreferencesModule: Module = module {
    single { createDataStore(androidContext()) }
}

