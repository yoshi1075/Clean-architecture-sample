package com.example.cleanarchitecturesample.feature_app.presentation.navigation

sealed class NavDestination(val route: String) {

    //region route
    data object Splash : NavDestination("splash")
    data object AuthGraph : NavDestination("auth_graph")
    data object AppContentsGraph : NavDestination("app_contents_graph")
    //endregion

    //region AuthGraph
    data object AuthTop : NavDestination("auth_top")
    data object Login : NavDestination("login")
    data object SignIn : NavDestination("sign_in")
    //endregion

    //region AppContents
    data object ProductList : NavDestination("product_list")
    data object StatisticsGraph : NavDestination("statistics_graph")
    data object StatisticsUser : NavDestination("statistics_user")
    data object StatisticsAll : NavDestination("statistics_all")
    data object Product : NavDestination("product/{${PRODUCT_ID}}") {
        fun passId(id: String): String = route.replace("{$PRODUCT_ID}", id)
    }
    //endregion

    companion object {
        const val PRODUCT_ID = "productId"
    }
}
