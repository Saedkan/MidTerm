package com.example.midterm.domain.usecase

import com.example.midterm.domain.repository.HobbyRepository

class GetHobbiesUseCase(private val repo: HobbyRepository) {
    operator fun invoke() = repo.getHobbies()
}