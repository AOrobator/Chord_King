package com.orobator.chordking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.orobator.chordking.buildChord.BuildAChordViewModel
import com.orobator.chordking.home.ChordKingHomeScreen
import com.orobator.chordking.navigation.ChordKingNavHost
import com.orobator.chordking.ui.theme.ChordKingTheme
import timber.log.Timber

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (BuildConfig.DEBUG) {
            // Add thread name to tag
            Timber.plant(object : Timber.DebugTree() {
                override fun createStackElementTag(element: StackTraceElement): String {
                    return "[${Thread.currentThread().name.take(MAX_TAG_LEN)}]" +
                            "${super.createStackElementTag(element)}"
                }

                override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
                    // Cut up log lines if they're too long
                    if (message.length > MAX_LOGCAT_MESSAGE_LENGTH) {
                        super.log(priority, tag, message.substring(0, MAX_LOGCAT_MESSAGE_LENGTH), t)
                        log(priority, tag, message.substring(MAX_LOGCAT_MESSAGE_LENGTH), t)
                    } else {
                        super.log(priority, tag, message, t)
                    }
                }
            })
        }

        setContent {
            ChordKingTheme {
                ChordKingNavHost(
                    BuildAChordViewModel()
                )
            }
        }
    }

    companion object {
        private const val MAX_TAG_LEN = 20
        private const val MAX_LOGCAT_MESSAGE_LENGTH = 4000
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ChordKingTheme {
        ChordKingHomeScreen(
            onNameChordClick = {},
            onBuildChordClick = {}
        )
    }
}