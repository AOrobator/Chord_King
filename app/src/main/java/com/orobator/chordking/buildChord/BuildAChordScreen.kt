package com.orobator.chordking.buildChord

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.orobator.chordking.ui.theme.Strings

@Composable
fun BuildAChordScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = stringResource(Strings.build_a_chord)) })
        }
    ) {

    }
}