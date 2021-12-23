package com.orobator.chordking.buildChord

import com.orobator.chordking.architecture.BaseViewModel
import com.orobator.chordking.architecture.ViewState

class BuildAChordViewModel : BaseViewModel<BuildAChordViewState>(
    initialState = BuildAChordViewState()
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

    }

}

data class BuildAChordViewState(
    val chordToBuild: Chord = Chord(
        key = Note.NoteEFlat,
        quality = ChordQuality.Major
    ),
    val enteredNotes: List<Note> = emptyList()
) : ViewState