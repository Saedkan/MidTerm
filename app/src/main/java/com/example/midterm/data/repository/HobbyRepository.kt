package com.example.midterm.data.repository

import com.example.midterm.data.db.HobbyDao
import com.example.midterm.data.model.HobbyEntity
import com.example.midterm.domain.model.Hobby
import com.example.midterm.domain.repository.HobbyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HobbyRepositoryImpl(private val dao: HobbyDao) : HobbyRepository {
    override fun getHobbies(): Flow<List<Hobby>> = dao.getAll().map { list ->
        list.map { Hobby(it.id, it.title, it.description) }
    }

    override suspend fun insertHobby(hobby: Hobby) {
        dao.insert(HobbyEntity(hobby.id, hobby.title, hobby.description))
    }
}