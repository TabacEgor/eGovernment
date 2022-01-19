package com.tabac.egovernment.screens.login.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tabac.egovernment.R
import com.tabac.egovernment.screens.login.models.LoginViewState
import com.tabac.egovernment.ui.theme.Blue
import com.tabac.egovernment.ui.theme.LightBlue

@Composable
fun LoginViewInitial(
    modifier: Modifier = Modifier,
    state: LoginViewState.ViewStateInitial,
    onLoginChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginClick: () -> Unit,
    onForgotPasswordClick: (Int) -> Unit
) {
    Surface(
        color = Color.White,
    ) {
        Box() {
            LazyColumn(
                modifier = Modifier
                    .background(LightBlue)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                content = {
                    item {
                        Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
                            Text(
                                text = stringResource(id = R.string.login),
                            )

                            TextField(
                                modifier = Modifier
                                    .padding(top = 4.dp)
                                    .fillMaxWidth(),
                                singleLine = true,
                                value = state.login,
                                onValueChange = onLoginChanged,
                                colors = TextFieldDefaults.textFieldColors(
                                    textColor = Color.Black,
                                    focusedIndicatorColor = Color.Black,
                                    disabledIndicatorColor = Color.Black,
                                    cursorColor = Color.Black
                                )
                            )
                        }
                    }

                    item {
                        Column(modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)) {
                            Text(
                                text = stringResource(id = R.string.password),
                            )

                            TextField(
                                modifier = Modifier
                                    .padding(top = 4.dp)
                                    .fillMaxWidth(),
                                singleLine = true,
                                value = state.password,
                                onValueChange = onPasswordChanged,
                                colors = TextFieldDefaults.textFieldColors(
                                    textColor = Color.Black,
                                    focusedIndicatorColor = Color.Black,
                                    disabledIndicatorColor = Color.Black,
                                    cursorColor = Color.Black
                                )
                            )
                        }
                    }

                    item {
                        Button(
                            modifier = Modifier
                                .padding(top = 24.dp, start = 16.dp, end = 16.dp)
                                .height(48.dp)
                                .fillMaxWidth(),
                            onClick = onLoginClick,
                            colors = ButtonDefaults.buttonColors(backgroundColor = Blue)
                        ) {
                            Text(
                                text = stringResource(id = R.string.login),
                                color = Color.Black
                            )
                        }
                    }

                    item() {
                        Box(
                            modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            ClickableText(
                                text = AnnotatedString(stringResource(id = R.string.forgot_password)),
                                onClick = onForgotPasswordClick
                            )
                        }
                    }
                })
        }

    }
}

@Preview
@Composable
fun LoginViewInitial_Preview() {
    LoginViewInitial(
        state = LoginViewState.ViewStateInitial(),
        onLoginChanged = {},
        onPasswordChanged = {},
        onLoginClick = { },
        onForgotPasswordClick = {}
    )
}
