package com.example.cleanarchitecturesample.feature_app.presentation.screens.splash_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.cleanarchitecturesample.feature_app.presentation.navigation.NavDestination

fun NavGraphBuilder.splashRoute(navigateToAuthRoute: () -> Unit) {
    composable(route = NavDestination.Splash.route) {
        Column {
            Text("Splash")
            Button(
                onClick = { navigateToAuthRoute() }
            ) {
                Text("Go to Auth Top")
            }
        }
    }
}
