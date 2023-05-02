package com.kurly.app.config

import com.kurly.data.remote.ApiConfig
import javax.inject.Inject

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-02
 */
class ApiConfigImpl @Inject constructor() : ApiConfig {

    override val githubApiUrl: String
        get() = "https://api.github.com"
}