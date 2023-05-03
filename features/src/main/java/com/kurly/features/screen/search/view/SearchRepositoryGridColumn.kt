package com.kurly.features.screen.search.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kurly.designsystem.component.item.SearchRepositoryGridItem
import com.kurly.features.screen.search.items.SearchItem

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-03
 */
@Composable
fun SearchRepositoryGridColumn(
    modifier: Modifier = Modifier,
    searchItems: List<SearchItem>,
    onClickItem: (String) -> Unit
) {
    LazyVerticalGrid(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp),
        content = {
            items(
                items = searchItems,
                key = { it.hashCode() }
            ) { item: SearchItem ->
                when (item) {
                    is SearchItem.Repository -> {
                        SearchRepositoryGridItem(
                            title = item.name,
                            description = item.description,
                            thumbnailUrl = item.ownerAvatarUrl,
                            link = item.url,
                            hasWatcher = item.hasWatcher
                        ) {
                            onClickItem(item.description)
                        }
                    }
                    else -> {
                        // Draw another item
                    }
                }
            }
        }
    )
}