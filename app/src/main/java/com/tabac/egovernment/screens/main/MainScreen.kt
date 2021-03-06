package com.tabac.egovernment.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DeviceHub
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.Palette
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.tabac.egovernment.R
import com.tabac.egovernment.screens.documents.DocumentsScreen
import com.tabac.egovernment.screens.home.HomeScreen
import com.tabac.egovernment.screens.home.HomeViewModel
import com.tabac.egovernment.screens.settings.SettingsScreen
import com.tabac.egovernment.screens.votes.VotesScreen
import com.tabac.egovernment.ui.theme.Typography

@Composable
fun MainScreen(
    navController: NavHostController,
    mainViewModel: MainViewModel
) {
    val childNavController = rememberNavController()
    val items = listOf(
        NavigationRoutes.Home,
        NavigationRoutes.Documents,
        NavigationRoutes.Votes,
        NavigationRoutes.Settings
    )
    Scaffold(
        topBar = { AppBar() }
    ) {
        Column {
            Box(modifier = Modifier.weight(1f)) {
                NavHost(
                    navController = childNavController,
                    startDestination = NavigationRoutes.Home.route
                ) {
                    composable(NavigationRoutes.Home.route) {
                        val homeViewModel = hiltViewModel<HomeViewModel>()
                        HomeScreen(homeViewModel = homeViewModel, onSearchInputChanged = {})
                    }
                    composable(NavigationRoutes.Documents.route) {
                        DocumentsScreen()
                    }
                    composable(NavigationRoutes.Votes.route) {
                        VotesScreen()
                    }
                    composable(NavigationRoutes.Settings.route) {
                        SettingsScreen()
                    }
                }
            }

            Box(
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth(),
            ) {
                BottomNavigation {
                    val navBackStackEntry by childNavController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    val previousDestination = remember { mutableStateOf(items.first().route) }

                    items.forEach { screen ->
                        val isSelected = currentDestination?.hierarchy
                            ?.any { it.route == screen.route } == true

                        BottomNavigationItem(
                            icon = {
                                Icon(
                                    imageVector = when (screen) {
                                        NavigationRoutes.Home -> Icons.Filled.DeviceHub
                                        NavigationRoutes.Documents -> Icons.Filled.Face
                                        NavigationRoutes.Votes -> Icons.Filled.Favorite
                                        NavigationRoutes.Settings -> Icons.Filled.Settings
                                        else -> TODO()
                                    },
                                    contentDescription = null,
                                )
                            },
                            label = {
                                Text(
                                    stringResource(id = screen.resourceId),
                                    color = Color.Black,
                                    style = Typography.overline
                                )
                            },
                            selected = isSelected,
                            onClick = {
                                if (screen.route == previousDestination.value) return@BottomNavigationItem
                                previousDestination.value = screen.route

                                childNavController.navigate(screen.route) {
                                    popUpTo(childNavController.graph.findStartDestination().id) {
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
}

@Composable
private fun AppBar() {
    TopAppBar(
        navigationIcon = {
            Icon(
                imageVector = Icons.Rounded.Palette,
                contentDescription = null,
                modifier = Modifier.padding(horizontal = 12.dp)
            )
        },
        title = {
                Text(text = stringResource(id = R.string.egov))
        },
        backgroundColor = MaterialTheme.colors.primarySurface
    )
}

