package com.orobator.chordking.architecture

/**
 * Represents a change to a View.
 * Can either be [ViewState] or [ViewEffect].
 */
interface ViewChange {
    /** Cleans up verbose toString() implementations.*/
    fun sanitizedToString(): String {
        val rawString = this.toString()

        return if (rawString.startsWith("com.geneva.chat")) {
            this::class.java.simpleName
        } else {
            rawString
        }
            .replace(", ", ",\n")
            .replace("(", "(\n")
    }
}

/**
 * The current state of the view. Indicates whether loading, or can retry, etc.
 * This should generally be implemented by a Data Class.
 */
interface ViewState : ViewChange

/**
 * Represents transient effects that the view should do only once, such as
 * showing an error message, navigating to a different screen, or showing a
 * dialog. Should either be a Kotlin Object or a Data Class.
 */
interface ViewEffect : ViewChange
