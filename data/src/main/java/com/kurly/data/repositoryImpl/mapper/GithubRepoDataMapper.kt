package com.kurly.data.repositoryImpl.mapper

import com.kurly.data.remote.raw.response.GithubRepoRaw
import com.kurly.domain.entity.GithubRepoEntity

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-02
 */
internal class GithubRepoDataMapper {
    private val ownerDataMapper by lazy {
        GithubOwnerDataMapper()
    }

    fun to(from: GithubRepoRaw.Item): GithubRepoEntity = GithubRepoEntity(
        id = from.id,
        owner = ownerDataMapper.to(from.owner),
        name = from.name.orEmpty(),
        fullName = from.full_name.orEmpty(),
        description = from.description.orEmpty(),
        forkCount = from.forks_count,
        openIssueCount = from.open_issues_count,
        watcherCount = from.watchers_count
    )
}