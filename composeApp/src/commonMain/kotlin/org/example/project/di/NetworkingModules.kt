package org.example.project.di

import org.example.project.data.networking.client.createHttpClient
import org.example.project.data.networking.repo.UserRepo
import org.koin.dsl.module

val networkModule = module {
    single { createHttpClient() }
    single { UserRepo(get()) }
}