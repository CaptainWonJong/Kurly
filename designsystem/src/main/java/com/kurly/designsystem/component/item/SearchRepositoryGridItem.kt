package com.kurly.designsystem.component.item

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import com.kurly.designsystem.component.badge.LinkBadge
import com.kurly.designsystem.component.image.CircleAsyncImage
import com.kurly.designsystem.component.text.ItemDescriptionText
import com.kurly.designsystem.component.text.ItemTitleText
import com.kurly.designsystem.utils.DevicePreview

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-03
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchRepositoryGridItem(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    thumbnailUrl: String,
    link: String,
    hasWatcher: Boolean,
    onClickItem: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .clickable {
                onClickItem()
            }
            .fillMaxWidth()
            .background(Color.White)
            .clip(shape = RoundedCornerShape(4.dp))
            .border(
                border = BorderStroke(
                    width = 1.dp,
                    color = Color.DarkGray
                ),
                shape = RoundedCornerShape(4.dp)
            )
            .padding(
                horizontal = 10.dp,
                vertical = 6.dp
            ),
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        Box {
            CircleAsyncImage(
                imageUrl = thumbnailUrl,
                size = 60.dp
            )
            if (hasWatcher) {
                Badge(containerColor = Color.Red)
            }
        }

        Spacer(modifier = Modifier.height(6.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                ItemTitleText(
                    text = title,
                    modifier = modifier
                )

                Spacer(modifier = Modifier.height(4.dp))

                ItemDescriptionText(
                    text = description,
                    modifier = modifier
                )
            }

            val uriHandler = LocalUriHandler.current
            LinkBadge(link = link) {
                uriHandler.openUri(link)
            }
        }
    }
}

@DevicePreview
@Composable
fun SearchRepositoryGridItemPreview() {
    SearchRepositoryGridItem(
        modifier = Modifier,
        title = "qqqqqqq",
        description = "A promise library for JavaScript",
        thumbnailUrl = "https://avatars.githubusercontent.com/u/60294?v=4",
        link = "https://github.com/kriskowal",
        hasWatcher = true,
    ) {

    }
}