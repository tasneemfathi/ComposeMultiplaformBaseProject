package org.example.project.di

import org.example.project.AppViewModel
import org.example.project.ui.scence.add.AddNewViewModel
import org.example.project.ui.scence.users.UserViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

//expect val viewModelModule  : Module
val viewModelModule = module {
    viewModel { AppViewModel(get()) }
    viewModel { UserViewModel(get(), get()) }
    viewModel { AddNewViewModel(get()) }
}