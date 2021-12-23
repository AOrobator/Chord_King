package com.orobator.chordking.buildChord

import com.orobator.chordking.buildChord.Note.NoteA
import com.orobator.chordking.buildChord.Note.NoteAFlat
import com.orobator.chordking.buildChord.Note.NoteASharp
import com.orobator.chordking.buildChord.Note.NoteB
import com.orobator.chordking.buildChord.Note.NoteBFlat
import com.orobator.chordking.buildChord.Note.NoteC
import com.orobator.chordking.buildChord.Note.NoteCFlat
import com.orobator.chordking.buildChord.Note.NoteCSharp
import com.orobator.chordking.buildChord.Note.NoteD
import com.orobator.chordking.buildChord.Note.NoteDFlat
import com.orobator.chordking.buildChord.Note.NoteDSharp
import com.orobator.chordking.buildChord.Note.NoteE
import com.orobator.chordking.buildChord.Note.NoteEFlat
import com.orobator.chordking.buildChord.Note.NoteESharp
import com.orobator.chordking.buildChord.Note.NoteF
import com.orobator.chordking.buildChord.Note.NoteFSharp
import com.orobator.chordking.buildChord.Note.NoteG
import com.orobator.chordking.buildChord.Note.NoteGFlat
import com.orobator.chordking.buildChord.Note.NoteGSharp

data class Chord(
    val key: Note,
    val quality: ChordQuality
) {
    val name: String = key.noteName + quality.qualityName

    fun notes(): List<Note> {
        val majorScale: List<Note> = majorScales[key]!!
        return quality.getChordTones(majorScale)
    }
}

val majorScales = mapOf(
    NoteFSharp to listOf(
        NoteFSharp,
        NoteGSharp,
        NoteASharp,
        NoteB,
        NoteCSharp,
        NoteDSharp,
        NoteESharp
    ),
    NoteB to listOf(NoteB, NoteCSharp, NoteDSharp, NoteE, NoteFSharp, NoteGSharp, NoteASharp),
    NoteE to listOf(NoteE, NoteFSharp, NoteGSharp, NoteA, NoteB, NoteCSharp, NoteDSharp),
    NoteA to listOf(NoteA, NoteB, NoteCSharp, NoteD, NoteE, NoteFSharp, NoteGSharp),
    NoteD to listOf(NoteD, NoteE, NoteFSharp, NoteG, NoteA, NoteB, NoteCSharp),
    NoteG to listOf(NoteG, NoteA, NoteB, NoteC, NoteD, NoteE, NoteFSharp),

    NoteC to listOf(NoteC, NoteD, NoteE, NoteF, NoteG, NoteA, NoteB),

    NoteF to listOf(NoteF, NoteG, NoteA, NoteBFlat, NoteC, NoteD, NoteE),
    NoteBFlat to listOf(NoteBFlat, NoteC, NoteD, NoteEFlat, NoteF, NoteG, NoteA),
    NoteEFlat to listOf(NoteEFlat, NoteF, NoteG, NoteAFlat, NoteBFlat, NoteC, NoteD),
    NoteAFlat to listOf(NoteAFlat, NoteBFlat, NoteC, NoteDFlat, NoteEFlat, NoteF, NoteG),
    NoteDFlat to listOf(NoteDFlat, NoteEFlat, NoteF, NoteGFlat, NoteAFlat, NoteBFlat, NoteC),
    NoteGFlat to listOf(NoteGFlat, NoteAFlat, NoteBFlat, NoteCFlat, NoteDFlat, NoteEFlat, NoteF),
)

enum class ChordQuality(val qualityName: String) {
    Major("Maj") {
        override fun getChordTones(scale: List<Note>): List<Note> {
            checkScale(scale)
            val root = scale[0]
            val majorThird = scale[2]
            val perfectFifth = scale[4]
            return listOf(root, majorThird, perfectFifth)
        }
    };
//    Minor("m"),
//    Diminished("dim"),
//    Augmented("aug"),
//    Major7("maj7"),
//    Minor7("min7"),
//    Dominant7("7"),
//    MinorMajor7("minMaj7");

    abstract fun getChordTones(scale: List<Note>): List<Note>

    protected fun checkScale(scale: List<Note>) {
        require(scale.size == 7) { "Scale has ${scale.size} notes, needs 7" }
    }
}
