package com.tabac.egovernment.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tabac.egovernment.base.BaseViewModel
import com.tabac.egovernment.base.EventHandler
import com.tabac.egovernment.screens.home.model.HomeEvent
import com.tabac.egovernment.screens.home.model.HomeViewState
import com.tabac.egovernment.util.logd
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel(), EventHandler<HomeEvent> {

    private val _homeViewState: MutableLiveData<HomeViewState> = MutableLiveData(HomeViewState.ViewStateInitial())
    val homeViewState: LiveData<HomeViewState> = _homeViewState

    override fun obtainEvent(event: HomeEvent) {
        when (val currentViewState = _homeViewState.value) {
            is HomeViewState.ViewStateInitial -> reduce(event = event, currentViewState)
            else -> {}
        }
    }

    private fun reduce(event: HomeEvent, currentState: HomeViewState.ViewStateInitial) {
        when (event) {
            is HomeEvent.SearchInputChange -> _homeViewState.postValue(currentState.copy(searchInput = event.newSearchInputValue))
            HomeEvent.SubmitSearch -> submitSearch()
        }
    }

    fun submitSearch() {
        logd("Submit search")
    }
}