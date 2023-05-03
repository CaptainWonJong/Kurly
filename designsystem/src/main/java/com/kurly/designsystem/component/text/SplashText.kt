@file:OptIn(ExperimentalAnimationApi::class)

package com.kurly.designsystem.component.text

import androidx.compose.animation.*
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import com.kurly.designsystem.utils.DevicePreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-02
 */
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SplashText(
    modifier: Modifier = Modifier,
    text: String = "Kurly",
    delayMillis: Long = 2000L
) {
    var isTextVisible by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        launch {
            isTextVisible = true
            delay(delayMillis)
            isTextVisible = false
        }
    }

    AnimatedVisibility(
        modifier = modifier,
        visible = isTextVisible,
        enter = scaleIn() + fadeIn(),
        exit = scaleOut() + fadeOut()
    ) {
        Text(
            modifier = Modifier.wrapContentSize(),
            text = text,
            style = androidx.compose.material3.Typography().displayLarge,
            color = Color.White,
            fontStyle = FontStyle.Italic
        )
    }
}

@DevicePreview
@Composable
private fun SplashTextPreview() {
    SplashText()
}