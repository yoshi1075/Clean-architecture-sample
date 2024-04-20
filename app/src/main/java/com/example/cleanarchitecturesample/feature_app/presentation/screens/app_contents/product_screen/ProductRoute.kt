package com.example.cleanarchitecturesample.feature_app.presentation.screens.app_contents.product_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.cleanarchitecturesample.feature_app.presentation.navigation.NavDestination

fun NavGraphBuilder.productRoute(
    popBackStack: () -> Unit,
    navigateToProduct: () -> Unit,
) {
    composable(
        NavDestination.Product.route,
        listOf(
            navArgument(NavDestination.PRODUCT_ID) { type = NavType.StringType }
        ),
    ) {
        val productId = it.arguments?.getString(NavDestination.PRODUCT_ID)
        Column {
            Text("商品 - productId: $productId")
            Button(
                onClick = { popBackStack() }
            ) {
                Text("popBack")
            }
            Button(
                onClick = { navigateToProduct() }
            ) {
                Text("Next Product")
            }
        }
    }
}
