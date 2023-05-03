package com.kurly.features.screen.search.mapper

import com.kurly.domain.entity.GithubRepoEntity
import com.kurly.features.screen.search.items.SearchItem

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-02
 */
internal class SearchItemMapper {
    fun to(from: GithubRepoEntity): SearchItem.Repository = SearchItem.Repository(
        id = from.id,
        name = from.name,
        description = from.description,
        url = from.owner.githubUrl,
        ownerAvatarUrl = from.owner.avatarUrl,
        hasWatcher = from.watcherCount > 0
    )
}