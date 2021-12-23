package com.orobator.chordking.buildChord

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
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
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment
import com.orobator.chordking.ui.theme.ChordKingTheme
import com.orobator.chordking.ui.theme.Colors
import com.orobator.chordking.ui.theme.Strings

@Composable
fun BuildAChordScreen(
    viewState: BuildAChordViewState,
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
                    text = stringResource(
                        Strings.build_a_chord_prompt,
                        viewState.chordToBuild.name
                    ),
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

                NoteEntryPad(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(16.dp)
                )
            }
        }
    }
}

@Composable
private fun NoteEntryPad(modifier: Modifier) {
    FlowRow(
        modifier = modifier,
        mainAxisSpacing = 24.dp,
        mainAxisAlignment = MainAxisAlignment.SpaceEvenly,
        crossAxisSpacing = 24.dp
    ) {
        for (note in Note.values()) {
            Button(
                modifier = Modifier.width(64.dp),
                onClick = { /*TODO*/ }
            ) {
                Text(text = note.noteName)
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