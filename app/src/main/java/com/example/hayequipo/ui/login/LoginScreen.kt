package com.example.hayequipo.ui.login


import androidx.navigation.NavController
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen (navController: NavController, homeViewModel: LoginViewModel){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0, 100, 0))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("fulbito", color = Color.White, fontFamily = FontFamily.Monospace, fontSize = 60.sp)

            Spacer(modifier = Modifier.height(50.dp))

            TextField(
                value = "",
                onValueChange = {},
                textStyle = TextStyle(color = Color.Black),
                placeholder = { Text("Usuario") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            TextField(
                value = "",
                onValueChange = {},
                textStyle = TextStyle(color = Color.Black),
                placeholder = { Text("Contraseña") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            Button(
                onClick = { /* Acción de ingreso */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .height(48.dp)
                    .background(Color.Black)
            ) {
                Text(text = "Ingresar", color = Color.White, fontFamily = FontFamily.Monospace, fontSize = 20.sp)
            }
            Spacer(modifier = Modifier.height(150.dp))
            Text(
                text = "Registrarse",
                color = Color.White,
                fontSize = 18.sp
            )
        }
    }
}




