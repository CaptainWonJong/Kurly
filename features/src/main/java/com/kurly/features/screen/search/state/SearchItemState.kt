package com.kurly.features.screen.search.state

import com.kurly.features.screen.search.items.SearchItem

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-02
 */
sealed interface SearchItemState {
    object Loading : SearchItemState

    object Empty : SearchItemState

    data class Content(
        val items: List<SearchItem>
    ) : SearchItemState

    object Error : SearchItemState
}