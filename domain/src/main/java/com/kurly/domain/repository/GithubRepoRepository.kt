package com.kurly.domain.repository

import com.kurly.domain.entity.GithubRepoEntity

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-02
 */
interface GithubRepoRepository {
    suspend fun getRepositories(query: String): List<GithubRepoEntity>
}