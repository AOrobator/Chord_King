package com.orobator.chordking.buildChord

data class Chord(
    val key: Note,
    val quality: ChordQuality
) {
    val name: String = key.noteName + quality.qualityName
}

enum class ChordQuality(val qualityName: String) {
    Major("Maj"),
    Minor("m"),
    Diminished("dim"),
    Augmented("aug"),
    Major7("maj7"),
    Minor7("min7"),
    Dominant7("7"),
    MinorMajor7("minMaj7"),
}