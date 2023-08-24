package com.example.hayequipo.ui

sealed class Routes(val route: String) {
    object LoginScreen : Routes("login")
    object HomeScreen : Routes("home")
}

