package com.example.midterm.domain.repository

import com.example.midterm.domain.model.Hobby
import kotlinx.coroutines.flow.Flow

interface HobbyRepository {
    fun getHobbies(): Flow<List<Hobby>>
    suspend fun insertHobby(hobby: Hobby)
}