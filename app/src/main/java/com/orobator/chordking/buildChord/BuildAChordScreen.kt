package com.orobator.chordking.buildChord

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.orobator.chordking.ui.theme.ChordKingTheme
import com.orobator.chordking.ui.theme.Colors
import com.orobator.chordking.ui.theme.Strings

@Composable
fun BuildAChordScreen(
    onBack: () -> Unit
) {
    ChordKingTheme {
        Scaffold(
            topBar = { BuildAChordAppBar(onBack) }
        ) {
            Column {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    text = stringResource(id = Strings.build_a_chord_prompt, "E♭"),
                    textAlign = TextAlign.Center,
                    fontSize = 32.sp,
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Colors.buildAChordBackgroundColor)
                        .padding(56.dp),
                    text = "Placeholder for chord entry",
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
private fun BuildAChordAppBar(
    onBack: () -> Unit
) {
    TopAppBar(
        backgroundColor = Colors.buildAChordBackgroundColor,
        title = {
            Text(
                text = stringResource(Strings.build_a_chord_title),
                color = Color.White,
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