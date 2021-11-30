package com.tabac.egovernment.screens.login.views

import android.content.res.Resources
import androidx.annotation.MainThread
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tabac.egovernment.R
import com.tabac.egovernment.screens.login.models.LoginViewState
import com.tabac.egovernment.ui.theme.LightBlue
import com.tabac.egovernment.ui.theme.Shapes

@Composable
fun LoginViewInitial(
    modifier: Modifier = Modifier,
    state: LoginViewState.ViewStateInitial,
    onLoginChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginClick: () -> Unit,
    onForgotPasswordClick: () -> Unit
) {
    Surface(
        color = Color.White
    ) {
        Box {
            LazyColumn(
                Modifier.background(LightBlue),
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
                        Row(modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)) {
                            TextField(
                                modifier = Modifier
                                    .padding(top = 4.dp)
                                    .fillMaxWidth(),
                                singleLine = true,
                                value = state.password,
                                onValueChange = onPasswordChanged
                            )

                        }
                    }

                    item {
                        Button(
                            modifier = Modifier
                                .padding(top = 24.dp, start = 16.dp, end = 16.dp)
                                .height(48.dp)
                                .fillMaxWidth(),
                            onClick = onLoginClick
                        ) {
//                            if (state.isSending) {
//                                CircularProgressIndicator(
//                                    modifier = Modifier.size(20.dp),
//                                    color = Color.White,
//                                    strokeWidth = 2.dp
//                                )
//                            } else {
//                                Text(
//                                    text = stringResource(id = R.string.action_add),
//                                    style = JetHabitTheme.typography.body,
//                                    color = Color.White
//                                )
//                            }
                        }
                    }

//                state.sendingError?.let { error ->
//                    item {
//                        ComposeViewInitialError(error = error)
//                    }
//                }
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
