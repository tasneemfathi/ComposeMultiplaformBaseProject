package org.example.project.di

import org.example.project.scence.add.AddNewViewModel
import org.example.project.scence.users.UserViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

//expect val viewModelModule  : Module
val viewModelModule = module {
    viewModel { UserViewModel(get()) }
    viewModel { AddNewViewModel(get()) }
}