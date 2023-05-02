package com.kurly.features.navigation

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-02
 */
sealed class ScreenRouter(val route: String) {
    object Splash : ScreenRouter("splash_screen")
    object Search : ScreenRouter("search_screen")
}