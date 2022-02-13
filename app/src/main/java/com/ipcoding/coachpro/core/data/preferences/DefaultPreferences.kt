package com.ipcoding.coachpro.core.data.preferences

import android.content.SharedPreferences
import com.ipcoding.coachpro.core.domain.preferences.Preferences
import com.ipcoding.coachpro.feature.presentation.util.Screen

class DefaultPreferences (
    private val sharedPreferences: SharedPreferences
    ) : Preferences {

    override fun saveClubName(name: String) {
        sharedPreferences
            .edit()
            .putString(Preferences.CLUB_NAME, name)
            .apply()
    }

    override fun saveSelectedLeague(name: String) {
        sharedPreferences
            .edit()
            .putString(Preferences.SELECTED_LEAGUE, name)
            .apply()
    }

    override fun saveColorJersey(color: Int) {
        sharedPreferences
            .edit()
            .putInt(Preferences.SELECTED_COLOR_JERSEY, color)
            .apply()
    }

    override fun saveColorStripes(color: Int) {
        sharedPreferences
            .edit()
            .putInt(Preferences.SELECTED_COLOR_STRIPES, color)
            .apply()
    }

    override fun saveTactics(tactics: String) {
        sharedPreferences
            .edit()
            .putString(Preferences.SELECTED_TACTICS, tactics)
            .apply()
    }

    override fun saveRoundNumber(round: Int) {
        sharedPreferences
            .edit()
            .putInt(Preferences.ROUND_NUMBER, round)
            .apply()
    }

    override fun saveYear(year: Int) {
        sharedPreferences
            .edit()
            .putInt(Preferences.YEAR, year)
            .apply()
    }

    override fun saveWeek(week: Int) {
        sharedPreferences
            .edit()
            .putInt(Preferences.WEEK, week)
            .apply()
    }

    override fun saveDestinationScreen(destinationScreen: String) {
        sharedPreferences
            .edit()
            .putString(Preferences.DESTINATION_SCREEN, destinationScreen)
            .apply()
    }

    override fun saveBudget(budget: Float) {
        sharedPreferences
            .edit()
            .putFloat(Preferences.BUDGET, budget)
            .apply()
    }

    override fun loadClubName(): String? {
        return sharedPreferences.getString(Preferences.CLUB_NAME, null)
    }

    override fun loadSelectedLeague(): String? {
        return sharedPreferences.getString(Preferences.SELECTED_LEAGUE, null)
    }

    override fun loadColorJersey(): Int {
        return sharedPreferences.getInt(Preferences.SELECTED_COLOR_JERSEY, -1)
    }

    override fun loadColorStripes(): Int {
        return sharedPreferences.getInt(Preferences.SELECTED_COLOR_STRIPES, -1)
    }

    override fun loadTactics(): String? {
        return sharedPreferences.getString(Preferences.SELECTED_TACTICS, "4-4-2")
    }

    override fun loadRoundNumber(): Int {
        return sharedPreferences.getInt(Preferences.ROUND_NUMBER, -1)
    }

    override fun loadYear(): Int {
        return sharedPreferences.getInt(Preferences.YEAR, -1)
    }

    override fun loadWeek(): Int {
        return sharedPreferences.getInt(Preferences.WEEK, -1)
    }

    override fun loadDestinationScreen(): String? {
        return sharedPreferences
            .getString(Preferences.DESTINATION_SCREEN, Screen.SelectLeagueScreen.route)
    }

    override fun loadBudget(): Float {
        return sharedPreferences.getFloat(Preferences.BUDGET, 0f)
    }
}