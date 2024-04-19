package com.example.cleanarchitecturesample.feature_app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.cleanarchitecturesample.feature_app.presentation.navigation.NavDestination
import com.example.cleanarchitecturesample.feature_app.presentation.navigation.appContentsRoute
import com.example.cleanarchitecturesample.feature_app.presentation.navigation.authGraph
import com.example.cleanarchitecturesample.feature_app.presentation.navigation.splashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val isLoggedIn = true
            val startDestination = if (isLoggedIn) {
                NavDestination.AppRoute.route
            } else {
                NavDestination.Splash.route
            }
            NavHost(
                navController = navController,
                startDestination = startDestination,
            ) {
                splashScreen { navController.navigate(NavDestination.AuthGraph.route) }
                authGraph(
                    { navController.navigate(NavDestination.AppRoute.route) },
                    { navController.navigate(NavDestination.Login.route) },
                    { navController.navigate(NavDestination.SignIn.route) },
                )
                appContentsRoute { navController.navigate(NavDestination.AuthGraph.route) }
            }
        }
    }
}
