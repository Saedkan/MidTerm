package com.example.midterm.di

import com.example.midterm.domain.usecase.GetHobbiesUseCase
import com.example.midterm.domain.usecase.InsertHobbyUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetHobbiesUseCase(get()) }
    factory { InsertHobbyUseCase(get()) }
}