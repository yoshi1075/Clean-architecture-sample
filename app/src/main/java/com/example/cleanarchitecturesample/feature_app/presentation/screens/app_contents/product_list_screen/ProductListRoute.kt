package com.example.cleanarchitecturesample.feature_app.presentation.screens.app_contents.product_list_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.cleanarchitecturesample.feature_app.presentation.navigation.NavDestination

fun NavGraphBuilder.productListRoute(navigateToProduct: () -> Unit) {
    composable(NavDestination.ProductList.route) {
        Column {
            val productId = (0..100).random()
            Text("商品一覧")
            Button(
                onClick = { navigateToProduct() }
            ) {
                Text("Go To Product")
            }
        }
    }
}
