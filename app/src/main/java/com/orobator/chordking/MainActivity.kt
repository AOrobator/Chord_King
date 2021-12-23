package com.orobator.chordking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.orobator.chordking.home.ChordKingHomeScreen
import com.orobator.chordking.ui.theme.ChordKingTheme

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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ChordKingTheme {
        ChordKingHomeScreen()
    }
}