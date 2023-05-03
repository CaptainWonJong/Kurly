package com.kurly.designsystem.component.image

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-03
 */
@Composable
fun CircleAsyncImage(
    imageUrl: String,
    size: Dp,
    backgroundColor: Color = Color(0xFFE6E6E6),
    contentDescription: String? = null,
    onLoading: ((AsyncImagePainter.State.Loading) -> Unit)? = null,
    onSuccess: ((AsyncImagePainter.State.Success) -> Unit)? = null,
    onError: ((AsyncImagePainter.State.Error) -> Unit)? = null,
) = SubcomposeAsyncImage(
    model = ImageRequest.Builder(LocalContext.current)
        .data(imageUrl)
        .crossfade(true)
        .build(),
    contentDescription = contentDescription,
    modifier = Modifier
        .clip(CircleShape)
        .background(backgroundColor)
        .size(size),
    contentScale = ContentScale.Crop,
    onLoading = onLoading,
    onSuccess = onSuccess,
    onError = onError
)