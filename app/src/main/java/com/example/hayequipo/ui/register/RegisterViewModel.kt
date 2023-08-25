package com.example.hayequipo.ui.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hayequipo.domain.model.User
import com.example.hayequipo.domain.usecases.CreateNewUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val createNewUserUseCase: CreateNewUserUseCase) : ViewModel(){

    var username by mutableStateOf("")
    var password by mutableStateOf("")
    var email by mutableStateOf("")
    var isOwner by mutableStateOf(false)

    fun createNewUser(){
        val user = User(username, email, password, isOwner)
       viewModelScope.launch(Dispatchers.IO){
           createNewUserUseCase.createUser(user)
       }
    }
}