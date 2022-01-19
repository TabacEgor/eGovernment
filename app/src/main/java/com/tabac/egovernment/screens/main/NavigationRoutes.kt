package com.tabac.egovernment.screens.main

import androidx.annotation.StringRes
import com.tabac.egovernment.R

sealed class NavigationRoutes(val route: String, @StringRes val resourceId: Int) {
    object Login : NavigationRoutes("LoginScreen", R.string.login)
    object Main : NavigationRoutes("MainScreen", R.string.main)

    object Home : NavigationRoutes("HomeScreen", R.string.home)
    object Documents : NavigationRoutes("DocumentsScreen", R.string.documents)
    object Votes : NavigationRoutes("VotesScreen", R.string.votes)
    object Settings: NavigationRoutes("SettingsScreen", R.string.settings)
    object GovServiceRegistration : NavigationRoutes("ServiceRegistrationScreen", R.string.service_registration)
}