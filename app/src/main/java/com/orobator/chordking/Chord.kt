package com.orobator.chordking

import com.orobator.chordking.Note.NoteA
import com.orobator.chordking.Note.NoteAFlat
import com.orobator.chordking.Note.NoteASharp
import com.orobator.chordking.Note.NoteB
import com.orobator.chordking.Note.NoteBFlat
import com.orobator.chordking.Note.NoteBSharp
import com.orobator.chordking.Note.NoteC
import com.orobator.chordking.Note.NoteCFlat
import com.orobator.chordking.Note.NoteCSharp
import com.orobator.chordking.Note.NoteD
import com.orobator.chordking.Note.NoteDFlat
import com.orobator.chordking.Note.NoteDSharp
import com.orobator.chordking.Note.NoteE
import com.orobator.chordking.Note.NoteEFlat
import com.orobator.chordking.Note.NoteESharp
import com.orobator.chordking.Note.NoteF
import com.orobator.chordking.Note.NoteFFlat
import com.orobator.chordking.Note.NoteFSharp
import com.orobator.chordking.Note.NoteG
import com.orobator.chordking.Note.NoteGFlat
import com.orobator.chordking.Note.NoteGSharp

data class Chord(
    val key: Note,
    val quality: ChordQuality
) {
    val name: String = key.noteName + quality.qualityName

    fun chordTones(): List<Note>? {
        return quality.getChordTones(key)
    }
}

val majorScales = mapOf(
    NoteCSharp to listOf(
        NoteCSharp,
        NoteDSharp,
        NoteESharp,
        NoteFSharp,
        NoteGSharp,
        NoteASharp,
        NoteBSharp
    ),
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
    NoteCFlat to listOf(
        NoteCFlat,
        NoteDFlat,
        NoteEFlat,
        NoteFFlat,
        NoteGFlat,
        NoteAFlat,
        NoteBFlat
    ),
)

val minorScales = mapOf(
    NoteCSharp to majorScales[NoteE]!!.toRelativeMinor(),
    NoteFSharp to majorScales[NoteA]!!.toRelativeMinor(),
    NoteB to majorScales[NoteD]!!.toRelativeMinor(),
    NoteE to majorScales[NoteG]!!.toRelativeMinor(),
    NoteA to majorScales[NoteC]!!.toRelativeMinor(),
    NoteD to majorScales[NoteF]!!.toRelativeMinor(),
    NoteG to majorScales[NoteBFlat]!!.toRelativeMinor(),

    NoteC to majorScales[NoteEFlat]!!.toRelativeMinor(),

    NoteF to majorScales[NoteAFlat]!!.toRelativeMinor(),
    NoteBFlat to majorScales[NoteDFlat]!!.toRelativeMinor(),
    NoteEFlat to majorScales[NoteGFlat]!!.toRelativeMinor(),
    NoteAFlat to majorScales[NoteCFlat]!!.toRelativeMinor(),
    NoteDFlat to null, // The following scales have too many flats so they're not used
    NoteGFlat to null,
    NoteCFlat to null,
)

fun List<Note>.toRelativeMinor(): List<Note> {
    return slice(5..6) + slice(0..4)
}

enum class ChordQuality(val qualityName: String) {
    Major("Maj") {
        override fun getChordTones(key: Note): List<Note> {
            val majorScale = majorScales[key]!!
            val root = majorScale[0]
            val majorThird = majorScale[2]
            val perfectFifth = majorScale[4]
            return listOf(root, majorThird, perfectFifth)
        }
    },
    Minor("m") {
        override fun getChordTones(key: Note): List<Note>? {
            val minorScale = minorScales[key] ?: return null
            val root = minorScale[0]
            val minorThird = minorScale[2]
            val perfectFifth = minorScale[4]
            return listOf(root, minorThird, perfectFifth)
        }
    },

    //    Diminished("dim"),
//    Augmented("aug"),
    Major6("6") {
        override fun getChordTones(key: Note): List<Note> {
            val majorScale = majorScales[key]!!
            val root = majorScale[0]
            val majorThird = majorScale[2]
            val perfectFifth = majorScale[4]
            val majorSixth = majorScale[5]
            return listOf(root, majorThird, perfectFifth, majorSixth)
        }
    },
    Minor6("-6") {
        override fun getChordTones(key: Note): List<Note>? {
            val minorScale = minorScales[key] ?: return null
            val majorScale = majorScales[key]!!
            val root = majorScale[0]
            val minorThird = minorScale[2]
            val perfectFifth = majorScale[4]
            val majorSixth = majorScale[5]
            return listOf(root, minorThird, perfectFifth, majorSixth)
        }
    },
    Major7("maj7") {
        override fun getChordTones(key: Note): List<Note> {
            val majorScale = majorScales[key]!!
            val root = majorScale[0]
            val majorThird = majorScale[2]
            val perfectFifth = majorScale[4]
            val majorSeventh = majorScale[6]
            return listOf(root, majorThird, perfectFifth, majorSeventh)
        }
    },
    Minor7("min7") {
        override fun getChordTones(key: Note): List<Note>? {
            val minorScale = minorScales[key] ?: return null
            val root = minorScale[0]
            val minorThird = minorScale[2]
            val perfectFifth = minorScale[4]
            val minorSeventh = minorScale[6]
            return listOf(root, minorThird, perfectFifth, minorSeventh)
        }
    },
    Dominant7("7") {
        override fun getChordTones(key: Note): List<Note>? {
            val majorScale = majorScales[key]!!
            val minorScale = minorScales[key] ?: return null
            val root = majorScale[0]
            val majorThird = majorScale[2]
            val perfectFifth = majorScale[4]
            val minorSeventh = minorScale[6]
            return listOf(root, majorThird, perfectFifth, minorSeventh)
        }
    },
    MinorMajor7("minMaj7") {
        override fun getChordTones(key: Note): List<Note>? {
            val majorScale = majorScales[key]!!
            val minorScale = minorScales[key] ?: return null
            val root = minorScale[0]
            val minorThird = minorScale[2]
            val perfectFifth = minorScale[4]
            val majorSeventh = majorScale[6]
            return listOf(root, minorThird, perfectFifth, majorSeventh)
        }
    };

    abstract fun getChordTones(key: Note): List<Note>?
}
