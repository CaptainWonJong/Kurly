package com.kurly.app.di.remote

import com.kurly.app.config.ApiConfigImpl
import com.kurly.data.remote.ApiConfig
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
abstract class ApiConfigModule {

    @Singleton
    @Binds
    abstract fun bindApiConfig(impl: ApiConfigImpl): ApiConfig
}