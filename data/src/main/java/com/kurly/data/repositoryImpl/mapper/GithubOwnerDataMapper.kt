package com.kurly.data.repositoryImpl.mapper

import com.kurly.data.remote.raw.response.GithubRepoRaw
import com.kurly.domain.entity.GithubOwnerEntity

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-02
 */
class GithubOwnerDataMapper {
    fun to(from: GithubRepoRaw.Owner): GithubOwnerEntity = GithubOwnerEntity(
        id = from.id,
        nickname = from.login.orEmpty(),
        avatarUrl = from.avatar_url.orEmpty(),
        githubUrl = from.html_url.orEmpty()
    )
}