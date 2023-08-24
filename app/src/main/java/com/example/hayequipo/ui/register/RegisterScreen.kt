package com.example.hayequipo.ui.register

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
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hayequipo.ui.Routes


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavController, viewModel: RegisterViewModel) {


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
                value = viewModel.username,
                onValueChange = { viewModel.username = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                placeholder = { Text("Email") },
            )

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
                onValueChange = { viewModel.password = it },
                placeholder = { Text("Contraseña") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

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
                    if( viewModel.isOwner )
                        navController.navigate(Routes.OwnerScreen.route)
                    else
                        navController.navigate(Routes.HomeScreen.route)
                          },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .height(48.dp)
                    .background(Color.Black)
            ) {
                Text(text = "Registrarse", color = Color.White, fontFamily = FontFamily.Monospace, fontSize = 20.sp)
            }
        }
    }
}