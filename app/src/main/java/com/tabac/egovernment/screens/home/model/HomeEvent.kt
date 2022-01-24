package com.tabac.egovernment.screens.home.model

sealed class HomeEvent {
    data class SearchInputChange(val newSearchInputValue: String) : HomeEvent()
    object SubmitSearch : HomeEvent()
}
