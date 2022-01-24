package com.tabac.egovernment.screens.main

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import com.tabac.egovernment.R

sealed class NavigationRoutes(val route: String, @StringRes val resourceId: Int) {
    object Splash : NavigationRoutes("SplashScreen", R.string.splash)
    object Login : NavigationRoutes("LoginScreen", R.string.login)
    object SignUp : NavigationRoutes("ServiceRegistrationScreen", R.string.service_registration)
    object Main : NavigationRoutes("MainScreen", R.string.main)

    // Bottom Navigation
    object Home : NavigationRoutes("HomeScreen", R.string.home)
    object Documents : NavigationRoutes("DocumentsScreen", R.string.documents)
    object Votes : NavigationRoutes("VotesScreen", R.string.votes)
    object Settings: NavigationRoutes("SettingsScreen", R.string.settings)
}

class NavigationActions(navController: NavHostController) {

}

//sealed class MainBottomNavigationRoutes(
//    val route: String,
//    @StringRes val resourceId: Int,
//    val icon: ImageVector? = null,
//    val body: @Composable ((String) -> Unit)? = null
//) {
//    object Home : MainBottomNavigationRoutes("HomeScreen", R.string.home)
//    object Documents : MainBottomNavigationRoutes("DocumentsScreen", R.string.documents)
//    object Votes : MainBottomNavigationRoutes("VotesScreen", R.string.votes)
//    object Settings: MainBottomNavigationRoutes("SettingsScreen", R.string.settings)
//}