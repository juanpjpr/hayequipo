package com.example.hayequipo.ui.register

import android.graphics.Bitmap
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hayequipo.R
import com.example.hayequipo.ui.FilledButton
import com.example.hayequipo.ui.InputField
import com.example.hayequipo.ui.Routes


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterOwnerScreen(navController: NavController, viewModel: RegisterOwnerViewModel) {
    Column(
        modifier = Modifier
            .background(Color(0, 100, 0))
            .fillMaxSize()
            .padding(16.dp)
    ) {
        InputField(
            value = viewModel.courtName,
            onValueChange = { viewModel.courtName = it },
            placeholder = stringResource(R.string.register_owner_court_name)
        )

        InputField(
            value = viewModel.address,
            onValueChange = { viewModel.address = it },
            placeholder = stringResource(R.string.register_owner_address)
        )

        InputField(
            value = viewModel.addressNro,
            onValueChange = { viewModel.addressNro = it },
            placeholder = stringResource(R.string.register_owner_address_nro)
        )

        FilledButton(
            text = stringResource(R.string.register_owner_register),
            onClick = { navController.navigate(Routes.HomeScreen.route) }
        )
    }
}