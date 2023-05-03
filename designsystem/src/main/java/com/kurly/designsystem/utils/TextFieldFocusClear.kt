package com.kurly.designsystem.utils

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.input.pointer.pointerInput

/**
 * Created by CaptainWonJong@gmail.com on 2023-05-03
 */
fun Modifier.addFocusClear(focusManager: FocusManager, doOnClear: () -> Unit = {}): Modifier {
    return pointerInput(Unit) {
        detectTapGestures(onTap = {
            doOnClear()
            focusManager.clearFocus()
        })
    }
}