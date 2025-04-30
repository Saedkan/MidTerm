package com.example.midterm.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.midterm.domain.model.Hobby
import com.example.midterm.domain.usecase.GetHobbiesUseCase
import com.example.midterm.domain.usecase.InsertHobbyUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HobbyViewModel(
    private val getHobbies: GetHobbiesUseCase,
    private val insertHobby: InsertHobbyUseCase
) : ViewModel() {

    val hobbies = getHobbies().stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

    fun addHobby(title: String, desc: String) {
        viewModelScope.launch {
            insertHobby(Hobby(title = title, description = desc))
        }
    }
}