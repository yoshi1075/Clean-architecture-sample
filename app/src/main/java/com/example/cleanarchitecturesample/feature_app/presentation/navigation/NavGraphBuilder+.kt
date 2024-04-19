package com.example.cleanarchitecturesample.feature_app.presentation.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation

fun NavGraphBuilder.splashScreen(navigateToAuthRoute: () -> Unit) {
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

fun NavGraphBuilder.authGraph(
    navigateToAppRoute: () -> Unit,
    navigateToSignIn: () -> Unit,
    navigateToLogIn: () -> Unit,
) {
    navigation(
        route = NavDestination.AuthGraph.route,
        startDestination = NavDestination.AuthTop.route,
    ) {
        composable(NavDestination.AuthTop.route) {
            Column {
                Text("Auth Top")
                Button(
                    onClick = { navigateToLogIn() }
                ) {
                    Text("Go To Login")
                }
                Button(
                    onClick = { navigateToSignIn() }
                ) {
                    Text("Go To Sign In")
                }
            }
        }
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
}

fun NavGraphBuilder.appContentsRoute(
    navigateToAuthGraph: () -> Unit,
) {
    composable(
        route = NavDestination.AppRoute.route,
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
                composable(NavDestination.ProductList.route) {
                    Column {
                        val productId = (0..100).random()
                        Text("商品一覧")
                        Button(
                            onClick = { navController.navigate("product/$productId") }
                        ) {
                            Text("Go To Product")
                        }
                    }
                }
                statisticsGraph { navController.navigate("product/${(0..100).random()}") }
                composable(
                    NavDestination.Product().route,
                    listOf(
                        navArgument(NavDestination.Product().key) { type = NavType.StringType }
                    ),
                ) {
                    val productId = it.arguments?.getString(NavDestination.Product().key)
                    Column {
                        Text("商品 - productId: $productId")
                        Button(
                            onClick = { navController.popBackStack() }
                        ) {
                            Text("popBack")
                        }
                        Button(
                            onClick = {
                                navController.navigate("product/${(0..100).random()}")
                            }
                        ) {
                            Text("Next Product")
                        }
                    }
                }
            }
        }
    }
}

fun NavGraphBuilder.statisticsGraph(navigateToProduct: () -> Unit) {
    navigation(
        route = NavDestination.StatisticsGraph.route,
        startDestination = NavDestination.StatisticsUser.route,
    ) {
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
}
