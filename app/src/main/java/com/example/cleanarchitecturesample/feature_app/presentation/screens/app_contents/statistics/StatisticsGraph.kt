package com.example.cleanarchitecturesample.feature_app.presentation.screens.app_contents.statistics

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.example.cleanarchitecturesample.feature_app.presentation.navigation.NavDestination
import com.example.cleanarchitecturesample.feature_app.presentation.screens.app_contents.statistics.statistics_all_screen.statisticsAllRoute
import com.example.cleanarchitecturesample.feature_app.presentation.screens.app_contents.statistics.statistics_user_screen.statisticsUserRoute

fun NavGraphBuilder.statisticsGraph(navigateToProduct: () -> Unit) {
    navigation(
        route = NavDestination.StatisticsGraph.route,
        startDestination = NavDestination.StatisticsUser.route,
    ) {
        statisticsUserRoute { navigateToProduct() }
        statisticsAllRoute { navigateToProduct() }
    }
}
