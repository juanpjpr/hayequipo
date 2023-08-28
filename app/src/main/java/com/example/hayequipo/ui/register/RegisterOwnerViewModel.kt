package com.example.hayequipo.ui.register

import androidx.lifecycle.ViewModel
import com.example.hayequipo.domain.usecases.Register
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterOwnerViewModel @Inject constructor(private val register: Register) : ViewModel(){
}