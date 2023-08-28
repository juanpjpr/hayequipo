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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hayequipo.R
import com.example.hayequipo.ui.Routes
import com.example.hayequipo.ui.TitleText


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
            TitleText(text = stringResource(R.string.register_register_title))
            Spacer(modifier = Modifier.height(70.dp))
            EmailField(viewModel)
            UsernameField(viewModel)
            PasswordField(viewModel)
            InvalidEmailText(viewModel)
            InvalidPasswordText(viewModel)
            OwnerCheckbox(viewModel)
            SubmitButton(navController, viewModel)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailField(viewModel: RegisterViewModel) {
    TextField(
        value = viewModel.email,
        onValueChange = {
            viewModel.email = it
            viewModel.isEmailValid =
                android.util.Patterns.EMAIL_ADDRESS.matcher(it).matches() || it.isBlank()
            viewModel.isButtonEnabled =
                viewModel.isPasswordValid && viewModel.isEmailValid
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Done
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        placeholder = { Text(stringResource(R.string.register_email)) },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsernameField(viewModel: RegisterViewModel) {
    TextField(
        value = viewModel.username,
        onValueChange = { viewModel.username = it },
        placeholder = { Text(stringResource(R.string.register_user)) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(viewModel: RegisterViewModel) {
    TextField(
        value = viewModel.password,
        onValueChange = {
            viewModel.password = it
            viewModel.isPasswordValid = it.length >= 6
            viewModel.updateEnabledButton()
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        placeholder = { Text(stringResource(R.string.register_pass)) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        visualTransformation = if (viewModel.passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        singleLine = true
    )
}

@Composable
fun InvalidEmailText(viewModel: RegisterViewModel) {
    if (!viewModel.isEmailValid) {
        Text(
            text = stringResource(R.string.register_email_invalid),
            color = Color.Red,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun InvalidPasswordText(viewModel: RegisterViewModel) {
    if (!viewModel.isPasswordValid) {
        Text(
            text = stringResource(R.string.register_pass_invalid),
            color = Color.Red,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun OwnerCheckbox(viewModel: RegisterViewModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(stringResource(R.string.register_are_you_owner), color = Color.White)
        Checkbox(
            checked = viewModel.isOwner,
            onCheckedChange = { viewModel.isOwner = it }
        )
    }
}

@Composable
fun SubmitButton(navController: NavController, viewModel: RegisterViewModel) {
    Button(
        onClick = {
            viewModel.createNewUser()
            if (viewModel.isOwner)
                navController.navigate(Routes.OwnerScreen.route)
            else
                navController.navigate(Routes.HomeScreen.route)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(48.dp)
            .background(
                if (viewModel.isButtonEnabled) Color.Black else Color.LightGray
            ),
        enabled = viewModel.isButtonEnabled
    ) {
        val buttonText = if (viewModel.isOwner) stringResource(R.string.register_next) else stringResource(R.string.register_register)
        Text(
            text = buttonText,
            color = Color.White,
            fontFamily = FontFamily.Monospace,
            fontSize = 20.sp
        )
    }
}
