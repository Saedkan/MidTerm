package com.example.midterm.di

import com.example.midterm.presentation.viewmodel.HobbyViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { HobbyViewModel(get(), get()) }
}