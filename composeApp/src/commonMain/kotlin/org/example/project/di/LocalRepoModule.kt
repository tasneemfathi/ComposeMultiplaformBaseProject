package org.example.project.di

import org.example.project.data.datastore.repo.AppConfigRepo
import org.example.project.data.datastore.repo.ProfileRepo
import org.koin.core.module.Module
import org.koin.dsl.module

val localRepoModule : Module  = module{
    single { AppConfigRepo(get()) }
    single { ProfileRepo(get()) }
}