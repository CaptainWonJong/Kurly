package com.kurly.domain.entity

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-02
 */
data class GithubRepoEntity(
    val id: Int,
    val owner: GithubOwnerEntity,
    val name: String,
    val fullName: String,
    val description: String,
    val forkCount: Int,
    val openIssueCount: Int,
    val watcherCount: Int
)