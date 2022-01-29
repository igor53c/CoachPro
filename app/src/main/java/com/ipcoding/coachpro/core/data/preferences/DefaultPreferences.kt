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

    override fun loadClubName(): String? {
        return sharedPreferences.getString(Preferences.CLUB_NAME, null)
    }
}