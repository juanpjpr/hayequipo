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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hayequipo.R
import com.example.hayequipo.ui.FilledButton
import com.example.hayequipo.ui.InputField
import com.example.hayequipo.ui.Routes
import com.example.hayequipo.ui.TitleText


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController, viewmodel: LoginViewModel) {
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
            TitleText(text = stringResource(R.string.login_title))
            Spacer(modifier = Modifier.height(50.dp))
            InputField(
                value = "",
                placeholder = stringResource(R.string.login_user),
                onValueChange = {}
            )
            InputField(
                value = "",
                placeholder = stringResource(R.string.login_pass),
                onValueChange = {}
            )
            FilledButton(
                text = stringResource(R.string.login_sign_in),
                onClick = { navController.navigate(Routes.HomeScreen.route) }
            )
            Spacer(modifier = Modifier.height(150.dp))
            OutlinedButton(
                text = stringResource(R.string.login_register),
                onClick = { navController.navigate(Routes.RegisterScreen.route) }
            )
        }
    }
}


@Composable
fun OutlinedButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 18.sp
        )
    }
}



