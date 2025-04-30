package com.example.midterm.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.midterm.data.model.HobbyEntity

@Database(entities = [HobbyEntity::class], version = 2)
abstract class HobbyDatabase : RoomDatabase() {
    abstract fun hobbyDao(): HobbyDao
}