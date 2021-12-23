package com.orobator.chordking.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.SnackbarData
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * Class for handling incoming snackbar messages and queueing them up to show.
 */
private class SnackbarMessageHandler {
    private val messageMap = mutableMapOf<String, SnackbarMessage>()

    fun getSnackbarMessage(snackbarData: SnackbarData): SnackbarMessage? {
        return messageMap[snackbarData.message]
    }

    suspend fun showSnackbar(
        snackbarHostState: SnackbarHostState,
        snackbarMessage: SnackbarMessage
    ) {
        val key = generateKey(snackbarMessage)
        messageMap[key] = snackbarMessage

        when (snackbarHostState.showSnackbar(message = key)) {
            SnackbarResult.Dismissed -> snackbarMessage.onDismiss()
            SnackbarResult.ActionPerformed -> snackbarMessage.performAction?.invoke()
        }
    }

    private fun generateKey(snackbarMessage: SnackbarMessage): String {
        return snackbarMessage.hashCode().toString()
    }
}

/**
 * SnackbarHost component that is responsible for showing predefined messages
 * using our style. `ChordKingSnackbarHost` uses default compose `SnackbarHost`
 * to take care of queuing snackbars and performing actions on them. We would
 * send a message key down the `SnackbarHost` and later this key is used to
 * retrieve our predefined SnackMessage.
 *
 * @param contentColor Color for action label.
 * @param snackbarMessage Key to launch an effect to show corresponding
 * snackbar.
 */
@Composable
fun ChordKingSnackbarHost(
    state: SnackbarHostState,
    snackbarMessage: SnackbarMessage?,
    modifier: Modifier = Modifier,
    contentColor: Color = MaterialTheme.colors.primary
) {
    val handler = remember { SnackbarMessageHandler() }
    SnackbarHost(
        hostState = state,
        modifier = modifier,
        snackbar = { data ->
            when (val message = handler.getSnackbarMessage(data)) {
                is SnackbarMessage.ErrorMessage -> ErrorSnackbar(
                    errorMessage = message,
                    contentColor = contentColor
                )
                is SnackbarMessage.InfoMessage -> InfoSnackbar(
                    infoMessage = message,
                    contentColor = contentColor
                )
            }
        }
    )

    LaunchedEffect(key1 = snackbarMessage) {
        if (snackbarMessage != null) {
            handler.showSnackbar(state, snackbarMessage)
        }
    }
}
