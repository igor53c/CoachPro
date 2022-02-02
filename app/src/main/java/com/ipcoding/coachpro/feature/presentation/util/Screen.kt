package com.ipcoding.coachpro.feature.presentation.util

sealed class Screen(val route: String) {

    object SelectLeagueScreen: Screen("select_league_screen")
    object SelectClubScreen: Screen("select_club_screen")
    object ChooseColorJerseyScreen: Screen("choose_color_jersey_screen")
    object MainScreen: Screen("main_screen")
    object PlayersScreen: Screen("players_screen")
    object TableScreen: Screen("table_screen")
}