package com.kurly.features.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kurly.features.screen.search.SearchRoute
import com.kurly.features.screen.splash.SplashScreen

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-02
 */

@Composable
fun SetUpNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = ScreenRouter.Splash.route) {
        composable(route = ScreenRouter.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = ScreenRouter.Search.route) {
            SearchRoute()
        }
    }
}