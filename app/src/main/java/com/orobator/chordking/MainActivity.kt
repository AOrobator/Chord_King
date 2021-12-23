package com.orobator.chordking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.orobator.chordking.ui.theme.ChordKingTheme
import com.orobator.chordking.ui.theme.Colors

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChordKingTheme {
                ChordKingHomeScreen()
            }
        }
    }
}

@Composable
fun ChordKingHomeScreen() {
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            topBar = { ChordKingAppBar() }
        ) {
            Column(
                modifier = Modifier.padding(
                    vertical = 32.dp,
                    horizontal = 24.dp
                ),
                verticalArrangement = spacedBy(32.dp)
            ) {
                val buildAChordBackgroundColor = if (isSystemInDarkTheme()) {
                    Colors.DeepPurple400
                } else {
                    Colors.Purple300
                }
                HomeSelectionCard(
                    text = "Build a chord",
                    backgroundColor = buildAChordBackgroundColor
                )

                val nameThatChordBackgroundColor = if (isSystemInDarkTheme()) {
                    Colors.Blue400
                } else {
                    Colors.Blue300
                }
                HomeSelectionCard(
                    text = "Name that chord",
                    backgroundColor = nameThatChordBackgroundColor
                )
            }
        }
    }
}

@Composable
private fun ColumnScope.HomeSelectionCard(
    text: String,
    backgroundColor: Color
) {
    Card(
        modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(),
                onClick = {}
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ChordKingTheme {
        ChordKingHomeScreen()
    }
}