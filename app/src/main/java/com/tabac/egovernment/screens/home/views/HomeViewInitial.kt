package com.tabac.egovernment.screens.home.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tabac.egovernment.R
import com.tabac.egovernment.screens.home.model.HomeViewState

@Composable
fun HomeViewInitial(
    state: HomeViewState.ViewStateInitial,
    onSearchInputChanged: (String) -> Unit,
    onSubmitSearchClick: () -> Unit
) {
    Column() {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = stringResource(id = R.string.search)
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            TextField(
                value = state.searchInput,
                onValueChange = { onSearchInputChanged(it) },
                placeholder = { Text(stringResource(id = R.string.search_service)) },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(
                    onSearch = { onSubmitSearchClick() }
                )
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = {  }) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = stringResource(id = R.string.more_actions)
                )
            }

        }
        Text(text = "Home Screen")
        Button(onClick = { onSubmitSearchClick() }) {
            Text(text = "Search")
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun HomeViewInitial_Preview() {
    HomeViewInitial(
        state = HomeViewState.ViewStateInitial(),
        onSearchInputChanged = {},
        onSubmitSearchClick = {}
    )
}