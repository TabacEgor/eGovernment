package com.tabac.egovernment.screens.login.models

sealed class LoginEvent {
    data class LoginChanged(val newValue: String): LoginEvent()
    data class PasswordChanged(val newValue: String): LoginEvent()
    object LoginClick : LoginEvent()
    object ForgotPassword : LoginEvent()
    object SignUp : LoginEvent()
}