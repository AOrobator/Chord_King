package com.orobator.chordking.architecture

import androidx.annotation.VisibleForTesting
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import timber.log.Timber

/**
 * A [ViewModel] that implements the architectural pattern of Model-View-Intent,
 * or MVI.
 */
abstract class BaseViewModel<STATE : ViewState>(
    initialState: STATE,
    private val loggingEnabled: Boolean = false
) : ViewModel() {
    private val initialThreadName: String =
        Thread
            .currentThread()
            .name
    private val internalState: MutableState<STATE> = mutableStateOf(initialState)
    val viewStates: State<STATE> = internalState

    val viewState: STATE
        get() = viewStates.value

    /**
     * Use to relax thread check in unit tests.
     * When running coroutines in unit tests on local JVM (in blocked mode) there is no guarantee
     * that code will be invoked on the exact same thread where the class was created.
     * When running coroutines on Android, the scheduler works as expected.
     */
    @VisibleForTesting
    var checkMainThread = true

    private fun mainThreadCheck() {
        if (!checkMainThread) return

        check(
            Thread.currentThread().name == initialThreadName
        ) {
            "Don't update state off the main thread!" +
                    " Current thread = ${Thread.currentThread().name}"
        }
    }

    /**
     * [updateState] is the only place where a ViewModel can access the
     * [ViewState] and modify it. Once the state is updated, it will be available
     * to observers via the [viewStates] [State]
     */
    protected fun updateState(update: STATE.() -> STATE) {
        mainThreadCheck()
        val currentState: STATE = internalState.value
        val updatedState: STATE = currentState.update()
        if (loggingEnabled) {
            Timber.tag(this::class.java.simpleName)
            Timber.d("[State] ${updatedState.sanitizedToString()}")
        }
        internalState.value = updatedState
    }
}
