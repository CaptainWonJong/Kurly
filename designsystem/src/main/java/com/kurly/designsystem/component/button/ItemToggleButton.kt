package com.kurly.designsystem.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.kurly.designsystem.foundation.PrimaryPurple
import com.kurly.designsystem.utils.DevicePreview

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-03
 */
@Composable
fun ItemToggleButton(
    modifier: Modifier = Modifier,
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Text(
        modifier = modifier
            .clip(shape = CircleShape)
            .clickable { onClick() }
            .background(
                if (isSelected) {
                    PrimaryPurple
                } else {
                    Color.White
                }
            )
            .border(
                width = 1.dp,
                color = PrimaryPurple,
                shape = CircleShape
            )
            .padding(
                horizontal = 10.dp,
                vertical = 8.dp
            ),
        text = text,
        color = if (isSelected) {
            Color.White
        } else {
            PrimaryPurple
        },
        style = androidx.compose.material3.Typography().bodyMedium,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        fontWeight = FontWeight.Bold,
    )
}

@DevicePreview
@Composable
private fun ItemToggleButtonPreview() {
    Row {
        ItemToggleButton(
            text = "Linear",
            isSelected = true
        ) {

        }

        Spacer(modifier = Modifier.width(8.dp))

        ItemToggleButton(
            text = "Grid",
            isSelected = false
        ) {

        }
    }
}