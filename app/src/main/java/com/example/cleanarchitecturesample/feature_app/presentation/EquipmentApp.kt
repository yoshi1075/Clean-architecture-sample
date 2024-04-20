package com.example.cleanarchitecturesample.feature_app.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.cleanarchitecturesample.feature_app.presentation.navigation.NavDestination
import com.example.cleanarchitecturesample.feature_app.presentation.screens.app_contents.appContentsRoute
import com.example.cleanarchitecturesample.feature_app.presentation.screens.auth.authGraph
import com.example.cleanarchitecturesample.feature_app.presentation.screens.splash_screen.splashRoute

@Composable
fun EquipmentApp() {
    val navController = rememberNavController()
    val isLoggedIn = true
    val startDestination = if (isLoggedIn) {
        NavDestination.AppContentsGraph.route
    } else {
        NavDestination.Splash.route
    }
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        splashRoute { navController.navigate(NavDestination.AuthGraph.route) }
        authGraph(
            { navController.navigate(NavDestination.AppContentsGraph.route) },
            navController,
        )
        appContentsRoute { navController.navigate(NavDestination.AuthGraph.route) }
    }
}
