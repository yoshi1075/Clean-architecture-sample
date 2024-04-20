package com.example.cleanarchitecturesample.feature_app.presentation.screens.auth.login_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.cleanarchitecturesample.feature_app.presentation.navigation.NavDestination

fun NavGraphBuilder.loginRoute(navigateToAppRoute: () -> Unit) {
    composable(NavDestination.Login.route) {
        Column {
            Text("Login")
            Button(
                onClick = { navigateToAppRoute() }
            ) {
                Text("Go To App Route")
            }
        }
    }
}