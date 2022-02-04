package com.ipcoding.coachpro.core.domain.preferences

interface Preferences {

    fun saveClubName(name: String)
    fun saveSelectedLeague(name: String)
    fun saveColorJersey(color: Int)
    fun saveColorStripes(color: Int)
    fun saveTactics(tactics: String)

    fun loadClubName(): String?
    fun loadSelectedLeague(): String?
    fun loadColorJersey(): Int
    fun loadColorStripes(): Int
    fun loadTactics(): String?

    companion object {
        const val CLUB_NAME = "club_name"
        const val SELECTED_LEAGUE = "selected_league"
        const val SELECTED_COLOR_JERSEY = "selected_color_jersey"
        const val SELECTED_COLOR_STRIPES = "selected_color_stripes"
        const val SELECTED_TACTICS = "selected_tactics"
    }
}