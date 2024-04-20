package com.example.cleanarchitecturesample.feature_app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.cleanarchitecturesample.feature_app.presentation.navigation.NavDestination
import com.example.cleanarchitecturesample.feature_app.presentation.screens.app_contents.appContentsRoute
import com.example.cleanarchitecturesample.feature_app.presentation.screens.auth.authGraph
import com.example.cleanarchitecturesample.feature_app.presentation.screens.splash_screen.splashRoute

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EquipmentApp()
        }
    }
}
