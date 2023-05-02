package com.kurly.domain.usecase

import com.kurly.domain.entity.GithubRepoEntity
import com.kurly.domain.repository.GithubRepoRepository

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-02
 */
class GetGithubRepos(
    private val repository: GithubRepoRepository
) {
    suspend operator fun invoke(param: Param): List<GithubRepoEntity> = repository.getRepositories(param.searchQuery)

    data class Param(
        val searchQuery: String
    )
}