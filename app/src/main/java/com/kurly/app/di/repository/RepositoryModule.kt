package com.kurly.app.di.repository

import com.kurly.data.repositoryImpl.GithubRepoRepositoryImpl
import com.kurly.domain.repository.GithubRepoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-02
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindGithubRepoRepository(impl: GithubRepoRepositoryImpl): GithubRepoRepository
}