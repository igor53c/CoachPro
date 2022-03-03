package com.ipcoding.coachpro.core.data.preferences

import com.ipcoding.coachpro.core.domain.preferences.Preferences
import com.ipcoding.coachpro.feature.presentation.util.Screen

class DefaultPreferencesFake : Preferences {

    private var clubName: String? = null
    private var selectedLeague: String? = null
    private var colorJersey: Int = -1
    private var colorStripes: Int = -1
    private var tacticsValue: String? = "4-4-2"
    private var roundNumber: Int = -1
    private var yearValue: Int = -1
    private var weekValue: Int = -1
    private var destinationScreenValue: String? = Screen.SelectLeagueScreen.route
    private var budgetValue: Float = 0f
    private var numberJerseyValue: Int = 1

    override fun saveClubName(name: String) {
        clubName = name
    }

    override fun saveSelectedLeague(name: String) {
        selectedLeague = name
    }

    override fun saveColorJersey(color: Int) {
        colorJersey = color
    }

    override fun saveColorStripes(color: Int) {
        colorStripes = color
    }

    override fun saveTactics(tactics: String) {
        tacticsValue = tactics
    }

    override fun saveRoundNumber(round: Int) {
        roundNumber = round
    }

    override fun saveYear(year: Int) {
        yearValue = year
    }

    override fun saveWeek(week: Int) {
        weekValue = week
    }

    override fun saveDestinationScreen(destinationScreen: String) {
        destinationScreenValue = destinationScreen
    }

    override fun saveBudget(budget: Float) {
        budgetValue = budget
    }

    override fun saveNumberJersey(numberJersey: Int) {
        numberJerseyValue = numberJersey
    }

    override fun loadClubName(): String? {
        return clubName
    }

    override fun loadSelectedLeague(): String? {
        return selectedLeague
    }

    override fun loadColorJersey(): Int {
        return colorJersey
    }

    override fun loadColorStripes(): Int {
        return colorStripes
    }

    override fun loadTactics(): String? {
        return tacticsValue
    }

    override fun loadRoundNumber(): Int {
        return roundNumber
    }

    override fun loadYear(): Int {
        return yearValue
    }

    override fun loadWeek(): Int {
        return weekValue
    }

    override fun loadDestinationScreen(): String? {
        return destinationScreenValue
    }

    override fun loadBudget(): Float {
        return budgetValue
    }

    override fun loadNumberJersey(): Int {
        return numberJerseyValue
    }
}