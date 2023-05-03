package com.kurly.features.screen.search.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-03
 */
@Composable
fun SearchEmptyView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "Empty",
            color = Color.White,
            style = androidx.compose.material3.Typography().displayMedium,
        )
    }
}