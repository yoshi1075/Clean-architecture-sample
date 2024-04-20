package com.example.cleanarchitecturesample.feature_app.presentation.screens.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.cleanarchitecturesample.feature_app.presentation.navigation.NavDestination
import com.example.cleanarchitecturesample.feature_app.presentation.screens.auth.auth_top_screen.authTopRoute
import com.example.cleanarchitecturesample.feature_app.presentation.screens.auth.login_screen.loginRoute
import com.example.cleanarchitecturesample.feature_app.presentation.screens.auth.signin_screen.signInRoute

fun NavGraphBuilder.authGraph(
    navigateToAppRoute: () -> Unit,
    navController: NavController,
) {
    navigation(
        route = NavDestination.AuthGraph.route,
        startDestination = NavDestination.AuthTop.route,
    ) {
        authTopRoute(
            { navController.navigate(NavDestination.Login.route) },
            { navController.navigate(NavDestination.SignIn.route) },
        )
        loginRoute { navigateToAppRoute() }
        signInRoute { navigateToAppRoute() }
    }
}
