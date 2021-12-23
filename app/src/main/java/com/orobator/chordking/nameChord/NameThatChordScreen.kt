package com.orobator.chordking.nameChord

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.orobator.chordking.ui.theme.Colors
import com.orobator.chordking.ui.theme.Strings

@Composable
fun NameThatChordScreen() {
    Scaffold(
        topBar = { NameThatChordAppBar() }
    ) {

    }
}

@Composable
private fun NameThatChordAppBar() {
    TopAppBar(
        backgroundColor = Colors.nameThatChordBackgroundColor,
        title = {
            Text(
                text = stringResource(Strings.name_that_chord_title),
                color = Color.White
            )
        }
    )
}