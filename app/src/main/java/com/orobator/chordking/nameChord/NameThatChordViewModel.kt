package com.orobator.chordking.nameChord

import com.orobator.chordking.Chord
import com.orobator.chordking.ChordQuality
import com.orobator.chordking.Note
import com.orobator.chordking.Note.NoteAFlat
import com.orobator.chordking.architecture.BaseViewModel
import com.orobator.chordking.architecture.ViewState

class NameThatChordViewModel : BaseViewModel<NameThatChordViewState>(
    initialState = NameThatChordViewState()
) {


}

data class NameThatChordViewState(
    val shuffledChordTones: List<Note> = emptyList(),
    val chordToGuess: Chord = Chord(NoteAFlat, ChordQuality.Major)
) : ViewState