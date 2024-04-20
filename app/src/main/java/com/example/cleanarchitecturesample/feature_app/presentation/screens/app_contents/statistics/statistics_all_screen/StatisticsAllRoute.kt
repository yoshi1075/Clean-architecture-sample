package com.example.cleanarchitecturesample.feature_app.presentation.screens.app_contents.statistics.statistics_all_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.cleanarchitecturesample.feature_app.presentation.navigation.NavDestination

fun NavGraphBuilder.statisticsAllRoute(navigateToProduct: () -> Unit) {
    composable(NavDestination.StatisticsAll.route) {
        Column {
            Text("全体統計")
            Button(
                onClick = { navigateToProduct() }
            ) {
                Text("Go To Product")
            }
        }
    }
}
