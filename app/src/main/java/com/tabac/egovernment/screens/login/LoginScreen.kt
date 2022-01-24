package com.tabac.egovernment.screens.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.tabac.egovernment.screens.login.models.LoginEvent
import com.tabac.egovernment.screens.login.models.LoginViewState
import com.tabac.egovernment.screens.login.views.LoginViewError
import com.tabac.egovernment.screens.login.views.LoginViewInitial
import com.tabac.egovernment.screens.login.views.LoginViewLoading
import com.tabac.egovernment.screens.login.views.LoginViewSignUp
import com.tabac.egovernment.screens.main.NavigationRoutes

@Composable
fun LoginScreen(
    navController: NavHostController,
    loginViewModel: LoginViewModel
) {
    val viewState = loginViewModel.loginViewState.observeAsState(initial = LoginViewState.ViewStateInitial())
    when (val state = viewState.value) {
        is LoginViewState.ViewStateInitial -> LoginViewInitial(
                state = state,
                onLoginClick = { loginViewModel.obtainEvent(LoginEvent.LoginClick) },
                onLoginChanged = { loginViewModel.obtainEvent(LoginEvent.LoginChanged(it)) },
                onPasswordChanged = { loginViewModel.obtainEvent(LoginEvent.PasswordChanged(it)) },
                onForgotPasswordClick = { loginViewModel.obtainEvent(LoginEvent.ForgotPasswordClick) }
        )
        is LoginViewState.Loading -> { LoginViewLoading() }
        is LoginViewState.LoginSuccess -> { LaunchedEffect(key1 = Unit, block = {
                navController.navigate(route = NavigationRoutes.Main.route)
//                {
//                    popUpTo(navController.graph.findStartDestination().id) {
//                        saveState = true
//                    }
//                    launchSingleTop = true
//                    restoreState = true
//                }
            })
        }
        is LoginViewState.Error -> { LoginViewError() }
        LoginViewState.ForgotPassword -> ForgotPasswordScreen()
        LoginViewState.SignUp -> LoginViewSignUp()
    }
}
