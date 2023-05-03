package com.kurly.designsystem.component.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-03
 */
@Composable
fun ItemDescriptionText(
    text: String,
    modifier: Modifier
) {
    Text(
        text = text,
        modifier = modifier,
        color = Color.DarkGray,
        style = androidx.compose.material3.Typography().bodySmall,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}