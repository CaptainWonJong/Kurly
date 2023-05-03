package com.kurly.features.screen.search.items

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-02
 */
sealed interface SearchItem {
    data class Repository(
        val id: Int,
        val name: String,
        val description: String,
        val url: String,
        val ownerAvatarUrl: String,
        val hasWatcher: Boolean
    ): SearchItem
}