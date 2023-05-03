package com.kurly.designsystem.component.progress

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.kurly.designsystem.foundation.PrimaryPurple

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-03
 */
enum class ProgressType(
    val size: Dp,
    val strokeWidth: Dp
) {
    Large(100.dp, 10.dp),
    Medium(50.dp, 8.dp),
    Small(20.dp, 6.dp)
}

@Composable
fun LoadingProgress(
    modifier: Modifier = Modifier,
    progressType: ProgressType = ProgressType.Medium
) {
    CircularProgressIndicator(
        modifier = modifier.size(progressType.size),
        color = PrimaryPurple,
        strokeWidth = progressType.strokeWidth
    )
}