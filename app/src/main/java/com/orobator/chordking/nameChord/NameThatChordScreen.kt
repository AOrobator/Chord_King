package com.orobator.chordking.nameChord

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.orobator.chordking.ui.theme.ChordKingTheme
import com.orobator.chordking.ui.theme.Colors
import com.orobator.chordking.ui.theme.Strings

@Composable
fun NameThatChordScreen(
    onBack: () -> Unit
) {
    ChordKingTheme {
        Scaffold(
            topBar = { NameThatChordAppBar(onBack) }
        ) {

        }
    }
}

@Composable
private fun NameThatChordAppBar(
    onBack: () -> Unit
) {
    TopAppBar(
        backgroundColor = Colors.nameThatChordBackgroundColor,
        title = {
            Text(
                text = stringResource(Strings.name_that_chord_title),
                color = Color.White
            )
        },
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(Strings.content_description_navigate_up),
                    tint = Color.White
                )
            }
        }
    )
}