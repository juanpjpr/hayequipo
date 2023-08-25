package com.example.hayequipo.ui.screens.home


import androidx.lifecycle.ViewModel
import com.example.hayequipo.data.local.database.AppDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val database: AppDatabase) : ViewModel(){
}