@file:OptIn(ExperimentalMaterial3Api::class)

package com.kurly.features.screen.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kurly.features.screen.search.effects.HandleSearchSideEffects
import com.kurly.features.screen.search.items.SearchItem
import com.kurly.features.screen.search.state.SearchItemState

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-02
 */

@Composable
internal fun SearchRoute(
    viewModel: SearchViewModel = hiltViewModel()
) {
    val searchQuery by viewModel.searchQuery.collectAsStateWithLifecycle()
    val searchItemState by viewModel.searchItemState.collectAsStateWithLifecycle()

    HandleSearchSideEffects(effects = viewModel.sideEffects)

    SearchScreen(
        searchQuery = searchQuery,
        searchItemState = { searchItemState },
        typing = viewModel::typing,
        onClick = viewModel::showToast
    )
}

@Composable
private fun SearchScreen(
    searchQuery: String,
    searchItemState: () -> SearchItemState,
    typing: (String) -> Unit,
    onClick: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = searchQuery,
            onValueChange = typing
        )

        Spacer(modifier = Modifier.height(8.dp))

        // TODO: UI Component 개발
        when (val itemState = searchItemState()) {
            is SearchItemState.Loading -> {
                Text(text = "Loading")
            }
            is SearchItemState.Empty -> {
                Text(text = "Empty")
            }
            is SearchItemState.Error -> {
                Text(text = "Error")
            }
            is SearchItemState.Content -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    items(
                        items = itemState.items,
                        key = { it.hashCode() }
                    ) { item: SearchItem ->
                        when (item) {
                            is SearchItem.Repository -> {
                                Text(
                                    modifier = Modifier.clickable {
                                        onClick(item.description)
                                    },
                                    text = item.name
                                )
                            }
                            else -> {
                                // Draw another item
                            }
                        }
                    }
                }
            }
        }
    }
}