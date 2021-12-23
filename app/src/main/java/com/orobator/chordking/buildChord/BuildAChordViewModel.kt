package com.orobator.chordking.buildChord

import com.orobator.chordking.architecture.BaseViewModel
import com.orobator.chordking.architecture.ViewState
import com.orobator.chordking.ui.components.SnackbarMessage
import com.orobator.chordking.ui.theme.Strings

class BuildAChordViewModel : BaseViewModel<BuildAChordViewState>(
    initialState = BuildAChordViewState(
        chordToBuild = Chord(
            key = majorScales.keys.random(),
            quality = ChordQuality.values().random()
        )
    )
) {

    fun onNoteClick(note: Note) {
        updateState {
            copy(
                enteredNotes = viewState.enteredNotes + note
            )
        }
    }

    fun onDeleteNote() {
        updateState {
            copy(
                enteredNotes = viewState.enteredNotes.dropLast(1)
            )
        }
    }

    fun onDoneClick() {
        val chordTones = viewState.chordToBuild.notes()
        val enteredNotes = viewState.enteredNotes

        if (chordTones == enteredNotes) {
            updateState {
                copy(
                    snackbarMessage = SnackbarMessage.InfoMessage(
                        titleRes = Strings.build_a_chord_correct,
                        onDismiss = ::onDismissSnackbar
                    )
                )
            }

            var newChord = viewState.chordToBuild
            while (newChord == viewState.chordToBuild) {
                val newKey = majorScales.keys.random()
                val quality = ChordQuality.values().random()
                newChord = Chord(key = newKey, quality = quality)
            }
            updateState {
                copy(
                    chordToBuild = newChord,
                    enteredNotes = emptyList()
                )
            }
        } else {
            updateState {
                copy(
                    snackbarMessage = SnackbarMessage.ErrorMessage(
                        titleRes = Strings.build_a_chord_try_again,
                        onDismiss = ::onDismissSnackbar
                    )
                )
            }
        }
    }

    private fun onDismissSnackbar() {
        updateState { copy(snackbarMessage = null) }
    }
}

data class BuildAChordViewState(
    val chordToBuild: Chord = Chord(
        key = Note.NoteEFlat,
        quality = ChordQuality.Major
    ),
    val enteredNotes: List<Note> = emptyList(),
    val snackbarMessage: SnackbarMessage? = null
) : ViewState