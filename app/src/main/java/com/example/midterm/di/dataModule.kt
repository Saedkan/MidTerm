package com.example.midterm.di

import com.example.midterm.data.repository.HobbyRepositoryImpl
import com.example.midterm.domain.repository.HobbyRepository
import org.koin.dsl.module

val dataModule = module {
    single<HobbyRepository> { HobbyRepositoryImpl(get()) }
}