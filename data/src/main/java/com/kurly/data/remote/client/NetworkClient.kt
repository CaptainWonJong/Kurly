package com.kurly.data.remote.client

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.kurly.data.BuildConfig
import com.kurly.data.remote.ApiConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-02
 */
@OptIn(ExperimentalSerializationApi::class)
@Module
@InstallIn(SingletonComponent::class)
object NetworkClient {

    @Provides
    @Singleton
    fun provideRetrofitInstance(
        apiConfig: ApiConfig,
        httpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .baseUrl(apiConfig.githubApiUrl)
        .client(httpClient)
        .addConverterFactory(Json.asConverterFactory(CONTENT_TYPE.toMediaType()))
        .build()

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient = OkHttpClient.Builder().run {
        connectTimeout(TIMEOUT, TimeUnit.SECONDS)
        readTimeout(TIMEOUT, TimeUnit.SECONDS)
        writeTimeout(TIMEOUT, TimeUnit.SECONDS)

        addInterceptor(HttpLoggingInterceptor().apply {
            HttpLoggingInterceptor.Level.BODY
        })
        addInterceptor(provideRequest())
        addInterceptor(provideResponse())
        build()
    }

    @Provides
    @Singleton
    fun provideRequest(): Interceptor = Interceptor { chain ->
        chain.proceed(chain.request().newBuilder().apply {
            header("Content-Type", CONTENT_TYPE)
            header("Accept", CONTENT_TYPE)
            method(chain.request().method, chain.request().body)
        }.build())
    }

    @Provides
    @Singleton
    fun provideResponse(): Interceptor = Interceptor { chain ->
        val request = chain.request()
        return@Interceptor chain.proceed(request)
    }
}

private const val TIMEOUT = 30L
private const val CONTENT_TYPE = "application/json"