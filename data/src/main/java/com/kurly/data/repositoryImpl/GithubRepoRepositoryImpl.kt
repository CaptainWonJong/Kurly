package com.kurly.data.repositoryImpl

import com.kurly.data.remote.api.GithubRepoService
import com.kurly.data.repositoryImpl.mapper.GithubRepoDataMapper
import com.kurly.domain.entity.GithubRepoEntity
import com.kurly.domain.repository.GithubRepoRepository
import javax.inject.Inject

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-02
 */
class GithubRepoRepositoryImpl @Inject constructor(
    private val githubRepoService: GithubRepoService
) : GithubRepoRepository {
    private val repoDataMapper by lazy {
        GithubRepoDataMapper()
    }

    override suspend fun getRepositories(query: String): List<GithubRepoEntity> = githubRepoService.get(query).items.map { item ->
        repoDataMapper.to(item)
    }
}