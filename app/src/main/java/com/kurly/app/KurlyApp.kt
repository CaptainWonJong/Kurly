package com.kurly.app

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.disk.DiskCache
import coil.memory.MemoryCache
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-02
 */
@HiltAndroidApp
class KurlyApp : Application(), ImageLoaderFactory {

    private val diskCache: DiskCache by lazy {
        DiskCache.Builder()
            .directory(cacheDir.resolve(DISK_CACHE_DIRECTORY_PATH))
            .maxSizePercent(DISK_CACHE_MAX_SIZE_PERCENT)
            .build()
    }

    private val memoryCache: MemoryCache by lazy {
        MemoryCache.Builder(this)
            .maxSizePercent(MEMORY_CACHE_MAX_SIZE_PERCENT)
            .build()
    }

    override fun newImageLoader(): ImageLoader = ImageLoader
        .Builder(this)
        .memoryCache { memoryCache }
        .diskCache { diskCache }
        .crossfade(true)
        .build()

    private companion object {
        const val DISK_CACHE_MAX_SIZE_PERCENT = 0.02
        const val MEMORY_CACHE_MAX_SIZE_PERCENT = 0.25
        const val DISK_CACHE_DIRECTORY_PATH = "coil_image_cache"
    }
}