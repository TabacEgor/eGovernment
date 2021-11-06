package com.tabac.egovernment.screens.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.tabac.egovernment.BaseActivity
import com.tabac.egovernment.screens.LoginScreen
import com.tabac.egovernment.ui.theme.EGovernmentTheme

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EGovernmentTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    AppScreen()
                }
            }
        }
    }


}

@Composable
fun AppScreen() {
    var isUserLoggedIn by rememberSaveable { mutableStateOf(false) }
    if (isUserLoggedIn) {
        MainScreen()
    } else {
        LoginScreen(onLoginClicked = { isUserLoggedIn = !isUserLoggedIn })
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 480)
@Composable
fun DefaultPreview() {
    EGovernmentTheme {
        AppScreen()
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 480)
@Composable
fun MainScreenPreview() {
    EGovernmentTheme {
        MainScreen()
    }
}

//@Preview(
//    showBackground = true,
//    widthDp = 320,
//    uiMode = UI_MODE_NIGHT_YES,
//    name = "DefaultPreviewDark"
//)