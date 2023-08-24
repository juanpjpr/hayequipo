package com.example.hayequipo.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hayequipo.ui.login.LoginViewModel
import com.example.hayequipo.ui.screens.home.HomeScreen
import com.example.hayequipo.ui.screens.home.HomeViewModel
import com.example.hayequipo.ui.login.LoginScreen
import com.example.hayequipo.ui.register.RegisterScreen
import com.example.hayequipo.ui.register.RegisterViewModel

@Composable
fun NavigationView() {
    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = "login") {

        composable("login") {
            val viewModel = hiltViewModel<LoginViewModel>()
            LoginScreen(navController,viewModel)
        }

        composable("home") {
            val viewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(navController,viewModel)
        }


        composable("register") {
            val viewModel = hiltViewModel<RegisterViewModel>()
            RegisterScreen(navController,viewModel)
        }


    }


}