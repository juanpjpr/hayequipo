package com.example.hayequipo.ui.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.hayequipo.domain.usecases.Register
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterOwnerViewModel @Inject constructor(private val register: Register) : ViewModel(){

    var courtName by mutableStateOf("")
    var address by mutableStateOf("")
    var addressNro by mutableStateOf("")
}