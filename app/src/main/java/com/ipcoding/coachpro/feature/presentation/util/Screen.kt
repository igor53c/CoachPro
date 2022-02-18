package com.ipcoding.coachpro.feature.presentation.util

sealed class Screen(val route: String) {

    object SelectLeagueScreen : Screen("select_league_screen")
    object SelectClubScreen : Screen("select_club_screen")
    object ChooseJerseyScreen : Screen("choose_jersey_screen")
    object MainScreen : Screen("main_screen")
    object PlayersScreen : Screen("players_screen")
    object TableScreen : Screen("table_screen")
    object TacticsScreen : Screen("tactics_screen")
    object ScheduleScreen : Screen("schedule_screen")
    object InfoScreen : Screen("info_screen")
    object TransfersScreen : Screen("transfers_screen")
    object ResultScreen : Screen("result_screen")
    object HistoryScreen : Screen("history_screen")
    object SaleScreen : Screen("sale_screen")
}