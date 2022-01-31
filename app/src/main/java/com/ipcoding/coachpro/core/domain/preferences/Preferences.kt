package com.ipcoding.coachpro.core.domain.preferences

interface Preferences {

    fun saveClubName(name: String)
    fun saveSelecktedLeague(name: String)

    fun loadClubName(): String?
    fun loadSelecktedLeague(): String?

    companion object {
        const val CLUB_NAME = "club_name"
        const val SELECKTED_LEAGUE = "selected_league"
    }
}