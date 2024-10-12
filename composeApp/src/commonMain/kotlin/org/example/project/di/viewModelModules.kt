package org.example.project.di

import org.example.project.scence.start.StartViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

//expect val viewModelModule  : Module
val viewModelModule = module {
    viewModel { StartViewModel() }
}