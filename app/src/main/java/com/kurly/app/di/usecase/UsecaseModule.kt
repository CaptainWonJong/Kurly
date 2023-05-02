package com.kurly.app.di.usecase

import com.kurly.domain.repository.GithubRepoRepository
import com.kurly.domain.usecase.GetGithubRepos
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-02
 */
@Module
@InstallIn(ActivityRetainedComponent::class)
object UserUseCaseModule {

    @Provides
    fun provideGetGithubRepos(repository: GithubRepoRepository) = GetGithubRepos(repository)
}