package com.orobator.chordking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                HomeSelectionCard(
                    text = "Build a chord",
                    backgroundColor = Colors.Purple300
                )

                HomeSelectionCard(
                    text = "Name that chord",
                    backgroundColor = Colors.Blue300
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
            .fillMaxWidth(),
        backgroundColor = backgroundColor
    ) {
        Text(text)
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