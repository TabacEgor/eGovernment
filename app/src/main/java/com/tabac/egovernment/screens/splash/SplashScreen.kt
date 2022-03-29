package com.tabac.egovernment.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tabac.egovernment.R
import com.tabac.egovernment.screens.main.NavigationRoutes
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val isLoggedIn = rememberSaveable { mutableStateOf(false) } // temporary, this value should come from Storage

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier
            .align(Alignment.Center)) {
            Image(
                painter = painterResource(id = R.drawable.splash_image),
                contentDescription = "Splash image",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                "eGovernment",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp),
                fontSize = 42.sp
            )
        }
    }
    
    LaunchedEffect(key1 = Unit, block = {
        delay(3000L)
        if (isLoggedIn.value) {
            navController.navigate(route = NavigationRoutes.Main.route)
        } else {
            navController.navigate(route = NavigationRoutes.Login.route)
        }
    })
}

@Preview
@Composable
fun SplashScreen_Preview() {
//    SplashScreen()
}