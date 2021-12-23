package com.orobator.chordking.buildChord

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
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
import com.orobator.chordking.ui.components.ChordKingScaffold
import com.orobator.chordking.ui.theme.ChordKingTheme
import com.orobator.chordking.ui.theme.Colors
import com.orobator.chordking.ui.theme.Strings

@Composable
fun BuildAChordScreen(
    viewState: BuildAChordViewState,
    onNoteClick: (Note) -> Unit,
    onDeleteNoteClick: () -> Unit,
    onDoneClick: () -> Unit,
    onBack: () -> Unit
) {
    ChordKingTheme {
        ChordKingScaffold(
            topBar = { BuildAChordAppBar(onBack) },
            snackbarMessage = viewState.snackbarMessage
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
                        .padding(24.dp),
                    text = viewState.enteredNotes.joinToString { it.noteName },
                    fontSize = 42.sp,
                    textAlign = TextAlign.Center
                )

                Divider(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = MaterialTheme.colors.primary
                )

                NoteEntryPad(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(16.dp),
                    onDeleteNoteClick = onDeleteNoteClick,
                    onDoneClick = onDoneClick,
                    onNoteClick = onNoteClick
                )
            }
        }
    }
}

@Composable
private fun NoteEntryPad(
    modifier: Modifier,
    onNoteClick: (Note) -> Unit,
    onDeleteNoteClick: () -> Unit,
    onDoneClick: () -> Unit
) {
    FlowRow(
        modifier = modifier,
        mainAxisSpacing = 24.dp,
        mainAxisAlignment = MainAxisAlignment.SpaceEvenly,
        crossAxisSpacing = 20.dp
    ) {
        for (note in Note.values()) {
            Button(
                modifier = Modifier.width(64.dp),
                onClick = {
                    onNoteClick(note)
                }
            ) {
                Text(text = note.noteName)
            }
        }

        Button(onClick = onDeleteNoteClick) {
            Text(text = stringResource(Strings.build_a_chord_delete_note))
        }

        Button(onClick = onDoneClick) {
            Text(text = stringResource(Strings.build_a_chord_done))
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