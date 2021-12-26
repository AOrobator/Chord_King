package com.orobator.chordking.buildChord

import com.orobator.chordking.Chord
import com.orobator.chordking.ChordQuality
import com.orobator.chordking.Note
import com.orobator.chordking.architecture.BaseViewModel
import com.orobator.chordking.architecture.ViewState
import com.orobator.chordking.majorScales
import com.orobator.chordking.ui.components.SnackbarMessage
import com.orobator.chordking.ui.theme.Strings

class BuildAChordViewModel : BaseViewModel<BuildAChordViewState>(
    initialState = BuildAChordViewState(
        chordToBuild = getInitialChord()
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
        updateState {
            copy(questionsAnswered = viewState.questionsAnswered + 1)
        }

        val chordTones = viewState.chordToBuild.chordTones()!!
        val enteredNotes = viewState.enteredNotes

        if (chordTones == enteredNotes) {
            updateState {
                copy(
                    correctAnswers = viewState.correctAnswers + 1,
                    snackbarMessage = SnackbarMessage.InfoMessage(
                        titleRes = Strings.build_a_chord_correct,
                        onDismiss = ::onDismissSnackbar
                    )
                )
            }

            var newChord = viewState.chordToBuild
            // Ensure new chord is different from last chord
            while (newChord == viewState.chordToBuild || newChord.chordTones() == null) {
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

        updateState {
            copy(
                correctPercentage = "${((correctAnswers.toDouble() / questionsAnswered) * 100).toInt()}%"
            )
        }
    }

    private fun onDismissSnackbar() {
        updateState { copy(snackbarMessage = null) }
    }
}

private fun getInitialChord(): Chord {
    while (true) {
        val key = majorScales.keys.random()
        val quality = ChordQuality.values().random()

        val chord = Chord(key, quality)

        if (chord.chordTones() != null) {
            return chord
        }
    }
}

data class BuildAChordViewState(
    val chordToBuild: Chord = Chord(
        key = Note.NoteEFlat,
        quality = ChordQuality.Major
    ),
    val enteredNotes: List<Note> = emptyList(),
    val snackbarMessage: SnackbarMessage? = null,
    val questionsAnswered: Int = 0,
    val correctAnswers: Int = 0,
    val correctPercentage: String = ""
) : ViewState