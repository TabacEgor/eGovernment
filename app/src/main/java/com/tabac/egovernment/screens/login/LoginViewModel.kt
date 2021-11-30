package com.tabac.egovernment.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tabac.egovernment.base.BaseViewModel
import com.tabac.egovernment.base.EventHandler
import com.tabac.egovernment.screens.login.models.LoginEvent
import com.tabac.egovernment.screens.login.models.LoginViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : BaseViewModel(), EventHandler<LoginEvent> {

    private val _loginViewState: MutableLiveData<LoginViewState> = MutableLiveData(LoginViewState.ViewStateInitial())
    val loginViewState: LiveData<LoginViewState> = _loginViewState

    override fun obtainEvent(event: LoginEvent) {
        when (val currentViewState = _loginViewState.value) {
            is LoginViewState.ViewStateInitial -> reduce(event, currentViewState)
        }
    }

    private fun reduce(event: LoginEvent, currentState: LoginViewState.ViewStateInitial) {
        when (event) {
            is LoginEvent.LoginChanged -> _loginViewState.postValue(
                currentState.copy(login = event.newValue)
            )

        }
    }

    private fun login() {

    }

    private fun signUp() {

    }

    private fun forgotPassword() {

    }
}