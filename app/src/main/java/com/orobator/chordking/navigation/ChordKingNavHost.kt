package com.orobator.chordking.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.orobator.chordking.buildChord.BuildAChordScreen
import com.orobator.chordking.buildChord.BuildAChordViewModel
import com.orobator.chordking.home.ChordKingHomeScreen
import com.orobator.chordking.nameChord.NameThatChordScreen

@ExperimentalAnimationApi
@Composable
fun ChordKingNavHost(
    buildAChordViewModel: BuildAChordViewModel
) {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(
        navController = navController,
        startDestination = Destinations.Home.name
    ) {
        composable(
            Destinations.Home.name,
            enterTransition = {
                slideInHorizontally(initialOffsetX = { -it })
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = { -it })
            }
        ) {
            ChordKingHomeScreen(
                onBuildChordClick = { navController.navigate(Destinations.BuildAChord.name) },
                onNameChordClick = { navController.navigate(Destinations.NameThatChord.name) }
            )
        }

        composable(
            Destinations.BuildAChord.name,
            enterTransition = {
                slideInHorizontally(initialOffsetX = { it })
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = { it })
            }
        ) {
            val viewState by buildAChordViewModel.viewStates
            BuildAChordScreen(
                viewState = viewState,
                onBack = { navController.navigateUp() },
                onNoteClick = buildAChordViewModel::onNoteClick,
                onDoneClick = buildAChordViewModel::onDoneClick,
                onDeleteNoteClick = buildAChordViewModel::onDeleteNote,
                onBuildAChordSettingsClick = {}
            )
        }

        composable(
            Destinations.NameThatChord.name,
            enterTransition = {
                slideInHorizontally(initialOffsetX = { it })
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = { it })
            }
        ) {
            NameThatChordScreen(
                onBack = { navController.navigateUp() }
            )
        }
    }
}

enum class Destinations {
    Home,
    BuildAChord,
    NameThatChord
}
