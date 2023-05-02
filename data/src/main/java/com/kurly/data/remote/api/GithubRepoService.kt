package com.kurly.data.remote.api

import com.kurly.data.remote.raw.response.GithubRepoRaw
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-02
 */
interface GithubRepoService {

    @GET("search/repositories")
    suspend fun get(@Query("q") query: String): GithubRepoRaw
}