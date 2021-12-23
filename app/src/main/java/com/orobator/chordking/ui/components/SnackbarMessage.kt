package com.orobator.chordking.ui.components

import androidx.annotation.StringRes

sealed class SnackbarMessage(
    @StringRes val actionLabelRes: Int? = null,
    val performAction: (() -> Unit)? = null,
    val onDismiss: () -> Unit,
) {
    class ErrorMessage(
        @StringRes val titleRes: Int,
        actionLabelRes: Int? = null,
        performAction: (() -> Unit)? = null,
        onDismiss: () -> Unit,
    ) : SnackbarMessage(actionLabelRes, performAction, onDismiss)

    class InfoMessage(
        @StringRes val titleRes: Int,
        @StringRes val descriptionRes: Int? = null,
        actionLabelRes: Int? = null,
        performAction: (() -> Unit)? = null,
        onDismiss: () -> Unit,
    ) : SnackbarMessage(actionLabelRes, performAction, onDismiss)
}
