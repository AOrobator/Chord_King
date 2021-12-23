package com.orobator.chordking.nameChord

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.orobator.chordking.ui.theme.Strings

@Composable
fun NameThatChordScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = stringResource(Strings.name_that_chord_title)) })
        }
    ) {

    }
}