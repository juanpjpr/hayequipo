package com.example.hayequipo.ui.register

import android.graphics.Bitmap
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hayequipo.R
import com.example.hayequipo.ui.Routes


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterOwnerScreen(navController: NavController, viewModel: RegisterOwnerViewModel) {
    var nombre by remember { mutableStateOf(TextFieldValue()) }
    var fotos by remember { mutableStateOf(listOf<Bitmap?>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            placeholder = { Text(text = "Nombre Canchita") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Button(
                onClick = { navController.navigate(Routes.HomeScreen.route) }
            ) {
                Text(
                    text = "Registrarse",
                    color = Color.White,
                    fontSize = 18.sp
                )
            }
        }
    }
}