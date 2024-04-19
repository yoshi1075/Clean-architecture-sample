package com.example.cleanarchitecturesample.feature_app.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination

@Composable
fun BottomNavBar(
    navController: NavController
) {
    val items = listOf(
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

    NavigationBar {
        items.forEachIndexed { index, bottomBarItem ->
            NavigationBarItem(
                selected = navController.currentDestination?.hierarchy?.any {
                    it.route == bottomBarItem.route
                } ?: false,
                onClick = {
                    navController.navigate(bottomBarItem.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                },
                icon = { Icon(imageVector = bottomBarItem.icon, contentDescription = null) },
            )
        }
    }
}
