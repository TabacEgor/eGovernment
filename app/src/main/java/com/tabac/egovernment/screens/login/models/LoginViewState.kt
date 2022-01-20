package com.tabac.egovernment.screens.login.models

sealed class LoginViewState {
    data class ViewStateInitial(val login: String = "", val password: String = ""): LoginViewState()
    object Loading : LoginViewState()
    object Error : LoginViewState()
    object LoginSuccess : LoginViewState()
    object ForgotPassword : LoginViewState()
    object SignUp : LoginViewState()
}