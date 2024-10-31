package org.example.project.di

import org.koin.core.context.startKoin

actual class KoinInitializer {
    actual fun init() {
        startKoin {
            modules(viewModelModule, networkModule, DataStorePreferencesModule,localRepoModule)
        }
    }
}