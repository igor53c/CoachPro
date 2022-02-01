package com.ipcoding.coachpro.core.data.preferences

import android.content.SharedPreferences
import com.ipcoding.coachpro.core.domain.preferences.Preferences

class DefaultPreferences (
    private val sharedPreferences: SharedPreferences
    ) : Preferences {

    override fun saveClubName(name: String) {
        sharedPreferences
            .edit()
            .putString(Preferences.CLUB_NAME, name)
            .apply()
    }

    override fun saveSelecktedLeague(name: String) {
        sharedPreferences
            .edit()
            .putString(Preferences.SELECKTED_LEAGUE, name)
            .apply()
    }

    override fun saveColorJersey(color: Int) {
        sharedPreferences
            .edit()
            .putInt(Preferences.SELECKTED_COLOR_JERSEY, color)
            .apply()
    }

    override fun saveColorStripes(color: Int) {
        sharedPreferences
            .edit()
            .putInt(Preferences.SELECKTED_COLOR_STRIPES, color)
            .apply()
    }

    override fun loadClubName(): String? {
        return sharedPreferences.getString(Preferences.CLUB_NAME, null)
    }

    override fun loadSelecktedLeague(): String? {
        return sharedPreferences.getString(Preferences.SELECKTED_LEAGUE, null)
    }

    override fun loadColorJersey(): Int {
        return sharedPreferences.getInt(Preferences.SELECKTED_COLOR_JERSEY, -1)
    }

    override fun loadColorStripes(): Int {
        return sharedPreferences.getInt(Preferences.SELECKTED_COLOR_STRIPES, -1)
    }
}