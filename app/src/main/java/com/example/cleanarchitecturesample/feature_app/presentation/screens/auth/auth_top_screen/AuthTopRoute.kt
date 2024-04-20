package com.example.cleanarchitecturesample.feature_app.presentation.screens.auth.auth_top_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.cleanarchitecturesample.feature_app.presentation.navigation.NavDestination

fun NavGraphBuilder.authTopRoute(
    navigateToLogin: () -> Unit,
    navigateToSignIn: () -> Unit,
) {
    composable(NavDestination.AuthTop.route) {
        Column {
            Text("Auth Top")
            Button(
                onClick = { navigateToLogin() },
            ) {
                Text("Go To Login")
            }
            Button(
                onClick = { navigateToSignIn() },
            ) {
                Text("Go To Sign In")
            }
        }
    }
}
