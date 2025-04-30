package com.example.midterm.data.db

import androidx.room.*
import androidx.room.Dao
import com.example.midterm.data.model.HobbyEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HobbyDao {
    @Query("SELECT * FROM hobbies")
    fun getAll(): Flow<List<HobbyEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(hobby: HobbyEntity)
}