package com.kurly.features.screen.search.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kurly.designsystem.component.button.ItemToggleButton

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-03
 */
@Composable
fun SearchItemToggleRow(
    isLinear: Boolean = true,
    onClickLinear: () -> Unit,
    onClickGrid: () -> Unit,
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            ItemToggleButton(
                text = "Linear",
                isSelected = isLinear,
                onClick = onClickLinear
            )

            Spacer(modifier = Modifier.width(8.dp))

            ItemToggleButton(
                text = "Grid",
                isSelected = isLinear.not(),
                onClick = onClickGrid
            )
        }

        Divider(modifier = Modifier.background(color = Color(0xfff0f0f0)))
    }
}