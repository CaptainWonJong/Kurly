package com.kurly.features.screen.search.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kurly.designsystem.component.item.SearchRepositoryLinearItem
import com.kurly.features.screen.search.items.SearchItem

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-03
 */
@Composable
fun SearchRepositoryLinearColumn(
    modifier: Modifier = Modifier,
    searchItems: List<SearchItem>,
    onClickItem: (String) -> Unit,
) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        items(
            items = searchItems,
            key = { it.hashCode() }
        ) { item: SearchItem ->
            when (item) {
                is SearchItem.Repository -> {
                    SearchRepositoryLinearItem(
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
}