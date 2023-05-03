package com.kurly.designsystem.component.badge

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kurly.designsystem.utils.DevicePreview

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-03
 */
@Composable
fun LinkBadge(
    modifier: Modifier = Modifier,
    text: String = "Link",
    link: String,
    onClick: () -> Unit
) {
    val annotatedString = buildAnnotatedString {
        append(text)
        addStyle(
            style = SpanStyle(
                color = Color.Blue,
                fontSize = 12.sp,
                textDecoration = TextDecoration.Underline
            ),
            start = 0,
            end = text.length
        )
        addStringAnnotation(
            tag = text,
            annotation = link,
            start = 0,
            end = text.length
        )
    }
    ClickableText(
        modifier = modifier
            .background(Color.White)
            .clip(shape = RoundedCornerShape(4.dp))
            .border(
                border = BorderStroke(
                    width = 1.dp,
                    color = Color.Black
                ),
                shape = RoundedCornerShape(4.dp)
            )
            .padding(horizontal = 6.dp, vertical = 4.dp),
        text = annotatedString,
        onClick = {
            onClick()
        }
    )
}

@DevicePreview
@Composable
fun LinkBadgePreview() {
    val link = "https://www.naver.com"
    val uriHandler = LocalUriHandler.current
    LinkBadge(text = "LINK", link = link) {
        uriHandler.openUri(link)
    }
}