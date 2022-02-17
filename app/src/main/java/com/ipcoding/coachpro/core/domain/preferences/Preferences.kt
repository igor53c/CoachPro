package com.ipcoding.coachpro.core.domain.preferences

interface Preferences {

    fun saveClubName(name: String)
    fun saveSelectedLeague(name: String)
    fun saveColorJersey(color: Int)
    fun saveColorStripes(color: Int)
    fun saveTactics(tactics: String)
    fun saveRoundNumber(round: Int)
    fun saveYear(year: Int)
    fun saveWeek(week: Int)
    fun saveDestinationScreen(destinationScreen: String)
    fun saveBudget(budget: Float)
    fun saveNumberJersey(numberJersey: Int)

    fun loadClubName(): String?
    fun loadSelectedLeague(): String?
    fun loadColorJersey(): Int
    fun loadColorStripes(): Int
    fun loadTactics(): String?
    fun loadRoundNumber(): Int
    fun loadYear(): Int
    fun loadWeek(): Int
    fun loadDestinationScreen(): String?
    fun loadBudget(): Float
    fun loadNumberJersey(): Int

    companion object {
        const val CLUB_NAME = "club_name"
        const val SELECTED_LEAGUE = "selected_league"
        const val SELECTED_COLOR_JERSEY = "selected_color_jersey"
        const val SELECTED_COLOR_STRIPES = "selected_color_stripes"
        const val SELECTED_TACTICS = "selected_tactics"
        const val ROUND_NUMBER = "round_number"
        const val YEAR = "year"
        const val WEEK = "week"
        const val DESTINATION_SCREEN  = "destination_screen"
        const val BUDGET = "budget"
        const val NUMBER_JERSEY = "number_jersey"
    }
}