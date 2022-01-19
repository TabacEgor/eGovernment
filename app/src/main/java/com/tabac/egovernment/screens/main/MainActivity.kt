package com.tabac.egovernment.screens.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tabac.egovernment.base.BaseActivity
import com.tabac.egovernment.screens.login.LoginScreen
import com.tabac.egovernment.screens.login.LoginViewModel
import com.tabac.egovernment.ui.theme.EGovernmentTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            EGovernmentTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    NavHost(
                        navController = navController,
                        startDestination = NavigationRoutes.Login.route
                    ) {
                        composable(NavigationRoutes.Login.route) {
                            val loginViewModel = hiltViewModel<LoginViewModel>()
                            LoginScreen(
                                navController = navController,
                                loginViewModel = loginViewModel
                            )
                        }

                        composable(NavigationRoutes.Main.route) {
                            val mainViewModel = hiltViewModel<MainViewModel>()
                            MainScreen(navController = navController, mainViewModel = mainViewModel)
                        }
                    }
                }
            }
        }
    }
}

//@Preview(
//    showBackground = true,
//    widthDp = 320,
//    uiMode = UI_MODE_NIGHT_YES,
//    name = "DefaultPreviewDark"
//)
@Preview(showBackground = true, widthDp = 320, heightDp = 480)
@Composable
fun MainScreenPreview() {
    EGovernmentTheme {
//        MainScreen()
    }
}