package com.kurly.features

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.kurly.features.navigation.SetUpNavGraph
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-02
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        setContent {
            SetUpNavGraph(navController = rememberNavController())
        }
    }
}