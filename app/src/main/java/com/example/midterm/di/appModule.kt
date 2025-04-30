package com.example.midterm.di

import android.app.Application
import androidx.room.Room
import com.example.midterm.data.db.HobbyDatabase
import com.example.midterm.data.repository.HobbyRepositoryImpl
import com.example.midterm.domain.repository.HobbyRepository
import com.example.midterm.domain.usecase.GetHobbiesUseCase
import com.example.midterm.domain.usecase.InsertHobbyUseCase
import com.example.midterm.presentation.viewmodel.HobbyViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(
            get<Application>(),
            HobbyDatabase::class.java,
            "hobby_db"
        ).fallbackToDestructiveMigration().build()
    }

    single { get<HobbyDatabase>().hobbyDao() }

    single<HobbyRepository> { HobbyRepositoryImpl(get()) }

    factory { GetHobbiesUseCase(get()) }
    factory { InsertHobbyUseCase(get()) }

    viewModel { HobbyViewModel(get(), get()) }
}
