package com.ipcoding.coachpro.core.domain.preferences

interface Preferences {

    fun saveClubName(name: String)
    fun saveSelecktedLeague(name: String)
    fun saveColorJersey(color: Int)
    fun saveColorStripes(color: Int)

    fun loadClubName(): String?
    fun loadSelecktedLeague(): String?
    fun loadColorJersey(): Int
    fun loadColorStripes(): Int

    companion object {
        const val CLUB_NAME = "club_name"
        const val SELECKTED_LEAGUE = "selected_league"
        const val SELECKTED_COLOR_JERSEY = "selected_color_jersey"
        const val SELECKTED_COLOR_STRIPES = "selected_color_stripes"
    }
}