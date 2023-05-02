package com.kurly.features.screen.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.kurly.designsystem.component.SplashText
import com.kurly.designsystem.foundation.PrimaryPurple
import com.kurly.features.navigation.ScreenRouter
import kotlinx.coroutines.delay

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-02
 */
@Composable
internal fun SplashScreen(navController: NavHostController) {
    LaunchedEffect(Unit) {
        delay(SPLASH_DELAY_MILLIS)
        navController.navigate(ScreenRouter.Search.route) {
            popUpTo(ScreenRouter.Splash.route) {
                inclusive = true
                saveState = true
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = PrimaryPurple)
    ) {

        SplashText(
            modifier = Modifier
                .align(Alignment.Center),
            delayMillis = SPLASH_DELAY_MILLIS
        )
    }
}

private const val SPLASH_DELAY_MILLIS = 2000L