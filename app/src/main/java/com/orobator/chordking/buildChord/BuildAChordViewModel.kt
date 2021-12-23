package com.orobator.chordking.buildChord

import com.orobator.chordking.architecture.BaseViewModel
import com.orobator.chordking.architecture.ViewState

class BuildAChordViewModel :
    BaseViewModel<BuildAChordViewState>(initialState = BuildAChordViewState()) {

}

data class BuildAChordViewState(
    val chordToBuild: Chord = Chord(
        key = Note.NoteEFlat,
        quality = ChordQuality.Major
    )
) : ViewState