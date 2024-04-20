package com.example.cleanarchitecturesample.feature_app.presentation.screens.auth.signin_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.cleanarchitecturesample.feature_app.presentation.navigation.NavDestination

fun NavGraphBuilder.signInRoute(navigateToAppRoute: () -> Unit) {
    composable(NavDestination.SignIn.route) {
        Column {
            Text("Sign In")
            Button(
                onClick = { navigateToAppRoute() }
            ) {
                Text("Go To App Route")
            }
        }
    }
}
