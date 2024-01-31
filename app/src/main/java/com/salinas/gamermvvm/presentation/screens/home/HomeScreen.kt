@file:OptIn(ExperimentalMaterial3Api::class)

package com.salinas.gamermvvm.presentation.screens.home

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.*
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.wear.compose.material.ContentAlpha
import com.salinas.gamermvvm.presentation.navigation.HomeBottomBarNavGraph
import com.salinas.gamermvvm.presentation.navigation.HomeBottomBarScreen
import com.salinas.gamermvvm.presentation.ui.theme.Blue200
import com.salinas.gamermvvm.presentation.ui.theme.Red700

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) {
        HomeBottomBarNavGraph(navController = navController)
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        HomeBottomBarScreen.Posts,
        HomeBottomBarScreen.MyPosts,
        HomeBottomBarScreen.Profile,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val bottomBarDestination = screens.any { it.route == currentDestination?.route }

    if (bottomBarDestination) {
        BottomNavigation(
            backgroundColor = Blue200,  // Cambia el color de fondo a gris
            contentColor = Color.White  // Cambia el color de los íconos a blanco
        ) {
            screens.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: HomeBottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            androidx.compose.material.Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation icon"
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}
