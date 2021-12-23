package com.orobator.chordking.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.orobator.chordking.ui.theme.Colors
import com.orobator.chordking.ui.theme.Strings


@Composable
fun ChordKingHomeScreen(
    onBuildChordClick: () -> Unit,
    onNameChordClick: () -> Unit
) {
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            topBar = { ChordKingAppBar() }
        ) {
            Column(
                modifier = Modifier.padding(
                    vertical = 32.dp,
                    horizontal = 24.dp
                ),
                verticalArrangement = Arrangement.Absolute.spacedBy(32.dp)
            ) {
                val buildAChordBackgroundColor = if (isSystemInDarkTheme()) {
                    Colors.DeepPurple400
                } else {
                    Colors.Purple300
                }
                HomeSelectionCard(
                    text = stringResource(Strings.home_screen_build_a_chord),
                    backgroundColor = buildAChordBackgroundColor,
                    onClick = onBuildChordClick,
                )

                val nameThatChordBackgroundColor = if (isSystemInDarkTheme()) {
                    Colors.Blue400
                } else {
                    Colors.Blue300
                }
                HomeSelectionCard(
                    text = stringResource(Strings.home_screen_name_that_chord),
                    backgroundColor = nameThatChordBackgroundColor,
                    onClick = onNameChordClick
                )
            }
        }
    }
}

@Composable
private fun ColumnScope.HomeSelectionCard(
    text: String,
    backgroundColor: Color,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(),
                onClick = onClick
            ),
        backgroundColor = backgroundColor,
        elevation = 8.dp,
        shape = RoundedCornerShape(24.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 32.sp
            )
        }
    }
}

@Composable
private fun ChordKingAppBar() {
    TopAppBar(
        title = {
            Text(
                text = "👑 Chord King",
                color = Color.White
            )
        },
        backgroundColor = Colors.Purple500
    )
}