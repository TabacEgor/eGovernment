package com.tabac.egovernment.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.tabac.egovernment.R
import com.tabac.egovernment.model.UserInfo

@Composable
fun LoginScreen(onLoginClicked: () -> Unit, userInfo: UserInfo = UserInfo()) {
    Surface(
        color = Color.White
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CredentialsInputs()
            Button(onClick = onLoginClicked) {
                Text("Login")
            }
        }
    }
}

@Composable
fun CredentialsInputs() {
    Text(
        text = stringResource(id = R.string.login)
    )
    Text(
        text = stringResource(id = R.string.password)
    )
}
