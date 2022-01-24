package com.tabac.egovernment.screens.home

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.tabac.egovernment.screens.home.model.HomeEvent
import com.tabac.egovernment.screens.home.model.HomeViewState
import com.tabac.egovernment.screens.home.views.HomeViewInitial

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel,
    searchInput: String = "",
    onSearchInputChanged: (String) -> Unit
) {
    val viewState = homeViewModel.homeViewState.observeAsState(HomeViewState.ViewStateInitial())
    val context = LocalContext.current

    when (val state = viewState.value) {
        is HomeViewState.ViewStateInitial -> HomeViewInitial(
            state = state,
            onSearchInputChanged = { homeViewModel.obtainEvent(HomeEvent.SearchInputChange(it)) },
            onSubmitSearchClick = { homeViewModel.obtainEvent(HomeEvent.SubmitSearch) }
        )
    }
}

@Preview(
    uiMode = UI_MODE_NIGHT_NO,
    showBackground = true, widthDp = 320, heightDp = 480
)
@Composable
fun HomeScreen_Preview() {  }