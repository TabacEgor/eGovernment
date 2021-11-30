package com.tabac.egovernment.screens.login

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.navigation.NavController
import com.tabac.egovernment.screens.login.models.LoginEvent
import com.tabac.egovernment.screens.login.models.LoginViewState
import com.tabac.egovernment.screens.login.views.LoginViewInitial

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@Composable
fun LoginScreen(
    onLoginClicked: () -> Unit,
    navController: NavController,
    loginViewModel: LoginViewModel
) {
    val viewState = loginViewModel.loginViewState.observeAsState(initial = LoginViewState.ViewStateInitial())
    val keyboardController = LocalSoftwareKeyboardController.current

    when (val state = viewState.value) {
        is LoginViewState.ViewStateInitial -> LoginViewInitial(
                state = state,
                onLoginClick = {
                    keyboardController?.hide()
                    loginViewModel.obtainEvent(LoginEvent.LoginClick)
                   },
                onLoginChanged = { loginViewModel.obtainEvent(LoginEvent.LoginChanged(it)) },
                onPasswordChanged = { loginViewModel.obtainEvent(LoginEvent.PasswordChanged(it)) },
                onForgotPasswordClick = { }
        )
        is LoginViewState.Loading -> {  }
        is LoginViewState.LoginSuccess -> {  }
        is LoginViewState.Error -> {  }
    }
}
