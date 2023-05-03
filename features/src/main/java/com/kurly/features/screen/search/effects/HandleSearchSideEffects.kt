package com.kurly.features.screen.search.effects

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import com.kurly.features.utils.EffectFlow

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-02
 */
@Composable
internal fun HandleSearchSideEffects(
    effects: EffectFlow<SearchSideEffects?>
) {
    val context = LocalContext.current
    LaunchedEffect(effects) {
        effects.collect { effect ->
            when (effect) {
                is SearchSideEffects.OnToast -> {
                    Toast.makeText(context, effect.text, Toast.LENGTH_SHORT).show()
                }
                else -> {
                    // Nothing
                }
            }
        }
    }
}