package com.example.cleanarchitecturesample.feature_app.presentation.screens.app_contents

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cleanarchitecturesample.feature_app.presentation.navigation.BottomBarItem
import com.example.cleanarchitecturesample.feature_app.presentation.navigation.BottomNavBar
import com.example.cleanarchitecturesample.feature_app.presentation.navigation.NavDestination
import com.example.cleanarchitecturesample.feature_app.presentation.screens.app_contents.statistics.statisticsGraph
import com.example.cleanarchitecturesample.feature_app.presentation.screens.app_contents.product_list_screen.productListRoute
import com.example.cleanarchitecturesample.feature_app.presentation.screens.app_contents.product_screen.productRoute

fun NavGraphBuilder.appContentsRoute(navigateToAuthGraph: () -> Unit) {
    composable(
        route = NavDestination.AppContentsGraph.route,
    ) {
        val navController = rememberNavController()
        val bottomBarItems = listOf(
            BottomBarItem(
                NavDestination.ProductList.route,
                "Product",
                Icons.Filled.ShoppingCart,
            ),
            BottomBarItem(
                NavDestination.StatisticsGraph.route,
                "Statistics",
                Icons.Filled.Search,
            ),
        )
        Scaffold(
            bottomBar = { BottomNavBar(bottomBarItems, navController) }
        ) {
            NavHost(
                navController = navController,
                startDestination = NavDestination.ProductList.route,
                modifier = Modifier.padding(it),
            ) {
                productListRoute {
                    navController.navigate(NavDestination.Product.passId((0..100).random().toString()))
                }
                statisticsGraph {
                    navController.navigate(NavDestination.Product.passId((0..100).random().toString()))
                }
                productRoute(
                    { navController.popBackStack() },
                    { navController.navigate(NavDestination.Product.passId((0..100).random().toString())) },
                )
            }
        }
    }
}
