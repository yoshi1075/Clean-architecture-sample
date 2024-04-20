package com.example.cleanarchitecturesample.feature_app.presentation.screens.app_contents.statistics.statistics_user_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.cleanarchitecturesample.feature_app.presentation.navigation.NavDestination

fun NavGraphBuilder.statisticsUserRoute(navigateToProduct: () -> Unit) {
    composable(NavDestination.StatisticsUser.route) {
        Column {
            Text("個人統計")
            Button(
                onClick = { navigateToProduct() }
            ) {
                Text("Go To Product")
            }
        }
    }
}
