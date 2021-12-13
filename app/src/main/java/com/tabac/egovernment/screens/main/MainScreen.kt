package com.tabac.egovernment.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DeviceHub
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import com.tabac.egovernment.screens.VotesScreen
import com.tabac.egovernment.screens.home.HomeScreen
import com.tabac.egovernment.screens.settings.SettingsScreen

@Composable
fun MainScreen(
    navController: NavHostController,
//    mainViewModel: MainViewModel
) {
    val items = listOf(
        NavigationRoutes.Home,
        NavigationRoutes.Documents,
        NavigationRoutes.Votes,
        NavigationRoutes.Settings
    )
    Column() {
        Box(modifier = Modifier.weight(1f)) {
            VotesScreen()
        }
            Surface() {
                Box(
                    modifier = Modifier
                        .height(56.dp)
                        .fillMaxWidth(),
                ) {
                    BottomNavigation(modifier = Modifier.align(Alignment.BottomCenter)) {
                        val navBackStackEntry by navController.currentBackStackEntryAsState()
                        val currentDestination = navBackStackEntry?.destination
                        val previousDestination = remember { mutableStateOf(items.first().route) }

                        items.forEach { screen ->
                            val isSelected = currentDestination?.hierarchy
                                ?.any { it.route == screen.route } == true

                            BottomNavigationItem(
                                modifier = Modifier.background(Color.White),
                                icon = {
                                    Icon(
                                        imageVector = when (screen) {
                                            NavigationRoutes.Home -> Icons.Filled.DeviceHub
                                            NavigationRoutes.Documents -> Icons.Filled.Face
                                            NavigationRoutes.Votes -> Icons.Filled.Favorite
                                            NavigationRoutes.Settings -> Icons.Filled.Settings
                                            else -> Icons.Filled.Favorite
                                        },
                                        contentDescription = null,
                                    )
                                },
                                label = {
                                    Text(
                                        stringResource(id = screen.resourceId),
                                        color = Color.Black
                                    )
                                },
                                selected = isSelected,
                                onClick = {
                                    if (screen.route == previousDestination.value) return@BottomNavigationItem
                                    previousDestination.value = screen.route

                                    navController.navigate(screen.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }

                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                })
                        }
                    }
                }
            }
    }
//    VotesScreen() // temporary
}