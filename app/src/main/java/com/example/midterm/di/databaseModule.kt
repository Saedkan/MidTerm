package com.example.midterm.di

import android.app.Application
import androidx.room.Room
import com.example.midterm.data.db.HobbyDatabase
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            get<Application>(),
            HobbyDatabase::class.java,
            "hobby_db"
        ).fallbackToDestructiveMigration().build()
    }

    single { get<HobbyDatabase>().hobbyDao() }
}