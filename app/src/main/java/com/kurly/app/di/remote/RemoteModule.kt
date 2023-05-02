package com.kurly.app.di.remote

import com.kurly.data.remote.api.GithubRepoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-02
 */
@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    @Singleton
    fun provideGithubRepoService(retrofit: Retrofit): GithubRepoService = retrofit.create(GithubRepoService::class.java)
}