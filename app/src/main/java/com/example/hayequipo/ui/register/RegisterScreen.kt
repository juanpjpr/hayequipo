package com.example.hayequipo.ui.register

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hayequipo.ui.Routes


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavController, viewModel: RegisterViewModel) {
    var isEmailValid by remember { mutableStateOf(true) }
    var isPasswordValid by remember { mutableStateOf(true) }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    var isButtonEnabled by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .background(Color(0, 100, 0))
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Registro", fontSize = 30.sp)

            Spacer(modifier = Modifier.height(70.dp))

            TextField(
                value = viewModel.email,
                onValueChange = {
                    viewModel.email = it
                    isEmailValid = android.util.Patterns.EMAIL_ADDRESS.matcher(it).matches() || it.isBlank()
                    isButtonEnabled =  isPasswordValid && isEmailValid
                                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                placeholder = { Text("Email") },
            )
            if (!isEmailValid) {
                Text(
                    text = "Correo electrónico no válido",
                    color = Color.Red,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            TextField(
                value = viewModel.username,
                onValueChange = { viewModel.username = it },
                placeholder = { Text("Usuario") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            TextField(
                value = viewModel.password,
                onValueChange = {
                    viewModel.password = it
                    isPasswordValid = it.length >= 6
                    isButtonEnabled =  isPasswordValid && isEmailValid

                                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                placeholder = { Text("Contraseña") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                singleLine = true
            )
            if (!isPasswordValid) {
                Text(
                    text = "La contraseña debe tener al menos 6 caracteres",
                    color = Color.Red,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("¿Eres dueño de una canchita?", color = Color.White)
                Checkbox(
                    checked = viewModel.isOwner,
                    onCheckedChange = { viewModel.isOwner = it }
                )
            }

            Button(
                onClick = {
                    viewModel.createNewUser()
                    if( viewModel.isOwner )
                        navController.navigate(Routes.OwnerScreen.route)
                    else
                        navController.navigate(Routes.HomeScreen.route)
                          },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .height(48.dp)
                    .background(
                        if (isButtonEnabled) Color.Black else Color.LightGray
                    ),
                enabled = isButtonEnabled
            ) {
                if( viewModel.isOwner )
                    Text(text = "Siguiente", color = Color.White, fontFamily = FontFamily.Monospace, fontSize = 20.sp)
                else
                    Text(text = "Registrarse", color = Color.White, fontFamily = FontFamily.Monospace, fontSize = 20.sp)
            }
        }
    }
}