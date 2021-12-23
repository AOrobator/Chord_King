package com.orobator.chordking.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


object Colors {
    val Blue300 = Color(0xFF64B5F6)
    val Blue400 = Color(0xFF42A5F5)
    val Purple200 = Color(0xFFBB86FC)
    val Purple500 = Color(0xFF6200EE)
    val Purple700 = Color(0xFF3700B3)
    val DeepPurple700 = Color(0xFF512DA8)
    val DeepPurple400 = Color(0xFF7E57C2)
    val Teal200 = Color(0xFF03DAC5)

    val buildAChordBackgroundColor
        @Composable
        get() = if (isSystemInDarkTheme()) {
            DeepPurple700
        } else {
            DeepPurple400
        }

    val nameThatChordBackgroundColor
        @Composable get() =
            if (isSystemInDarkTheme()) {
                Blue400
            } else {
                Blue300
            }
}
