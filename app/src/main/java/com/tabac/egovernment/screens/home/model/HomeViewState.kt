package com.tabac.egovernment.screens.home.model

sealed class HomeViewState {
    data class ViewStateInitial(var searchInput: String = "") : HomeViewState()
}