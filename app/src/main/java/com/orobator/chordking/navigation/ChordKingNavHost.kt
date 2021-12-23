package com.orobator.chordking.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.orobator.chordking.buildChord.BuildAChordScreen
import com.orobator.chordking.home.ChordKingHomeScreen
import com.orobator.chordking.nameChord.NameThatChordScreen

@Composable
fun ChordKingNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destinations.Home.name
    ) {
        composable(Destinations.Home.name) {
            ChordKingHomeScreen(
                onBuildChordClick = { navController.navigate(Destinations.BuildAChord.name) },
                onNameChordClick = { navController.navigate(Destinations.NameThatChord.name) }
            )
        }

        composable(Destinations.BuildAChord.name) { BuildAChordScreen() }

        composable(Destinations.NameThatChord.name) { NameThatChordScreen() }
    }
}

enum class Destinations {
    Home,
    BuildAChord,
    NameThatChord
}
