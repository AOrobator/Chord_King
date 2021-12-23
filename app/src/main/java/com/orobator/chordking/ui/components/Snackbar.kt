package com.orobator.chordking.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.orobator.chordking.ui.components.SnackbarMessage.ErrorMessage
import com.orobator.chordking.ui.components.SnackbarMessage.InfoMessage
import com.orobator.chordking.ui.theme.ChordKingTypography
import com.orobator.chordking.ui.theme.Drawables

@Composable
fun ErrorSnackbar(
    errorMessage: ErrorMessage,
    contentColor: Color
) {
    Snackbar(
        modifier = Modifier.padding(12.dp),
        backgroundColor = Color.Red,
        shape = RoundedCornerShape(size = 16.dp),
        action = {
            SnackbarAction(
                snackbarMessage = errorMessage,
                contentColor = contentColor
            )
        }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(Drawables.ic_alert_icon),
                contentDescription = null,
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = stringResource(id = errorMessage.titleRes),
                style = ChordKingTypography.h4,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun InfoSnackbar(
    infoMessage: InfoMessage,
    contentColor: Color
) {
    Snackbar(
        modifier = Modifier.padding(12.dp),
        backgroundColor = MaterialTheme.colors.primary,
        shape = RoundedCornerShape(size = 16.dp),
        action = {
            SnackbarAction(
                snackbarMessage = infoMessage,
                contentColor = contentColor
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            val textColor = if (isSystemInDarkTheme()) {
                Color.Black
            } else {
                Color.White
            }
            Text(
                text = stringResource(infoMessage.titleRes),
                style = ChordKingTypography.h4,
                color = textColor
            )
            infoMessage.descriptionRes?.let {
                Text(text = stringResource(it), color = textColor)
            }
        }
    }
}

@Composable
private fun SnackbarAction(
    snackbarMessage: SnackbarMessage,
    contentColor: Color,
) {
    snackbarMessage.actionLabelRes?.let { actionLabelRes ->
        TextButton(
            colors = ButtonDefaults.textButtonColors(contentColor = contentColor),
            onClick = { snackbarMessage.performAction?.invoke() },
            content = {
                Text(
                    text = stringResource(actionLabelRes),
                    style = ChordKingTypography.h3,
                    modifier = Modifier.align(Alignment.Bottom)
                )
            },
        )
    }
}
