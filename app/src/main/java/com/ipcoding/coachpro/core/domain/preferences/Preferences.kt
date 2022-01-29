package com.ipcoding.coachpro.core.domain.preferences

interface Preferences {

    fun saveClubName(name: String)

    fun loadClubName(): String?

    companion object {
        const val CLUB_NAME = "club_name"
    }
}