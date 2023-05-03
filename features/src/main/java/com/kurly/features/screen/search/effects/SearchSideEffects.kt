package com.kurly.features.screen.search.effects

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-02
 */
sealed interface SearchSideEffects {
    data class OnToast(
        val text: String
    ): SearchSideEffects
}