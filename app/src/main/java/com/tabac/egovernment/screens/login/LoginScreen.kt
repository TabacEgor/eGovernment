package com.tabac.egovernment.screens.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import com.tabac.egovernment.screens.login.models.LoginEvent
import com.tabac.egovernment.screens.login.models.LoginViewState
import com.tabac.egovernment.screens.login.views.LoginViewInitial
import com.tabac.egovernment.screens.main.NavigationRoutes

@Composable
fun LoginScreen(
    navController: NavController,
    loginViewModel: LoginViewModel
) {
    val viewState = loginViewModel.loginViewState.observeAsState(initial = LoginViewState.ViewStateInitial())

    when (val state = viewState.value) {
        is LoginViewState.ViewStateInitial -> LoginViewInitial(
                state = state,
                onLoginClick = {
                    loginViewModel.obtainEvent(LoginEvent.LoginClick)
                    navController.navigate(NavigationRoutes.Main.route) {
                        popUpTo("LoginScreen")
                    }
                },
                onLoginChanged = { loginViewModel.obtainEvent(LoginEvent.LoginChanged(it)) },
                onPasswordChanged = { loginViewModel.obtainEvent(LoginEvent.PasswordChanged(it)) },
                onForgotPasswordClick = { loginViewModel.obtainEvent(LoginEvent.ForgotPassword) }
        )
        is LoginViewState.Loading -> {  }
        is LoginViewState.LoginSuccess -> {  }
        is LoginViewState.Error -> {  }
    }
}
