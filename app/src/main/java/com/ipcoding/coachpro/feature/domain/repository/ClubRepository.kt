package com.ipcoding.coachpro.feature.domain.repository

import com.ipcoding.coachpro.feature.domain.model.Club

interface ClubRepository {

    suspend fun insertClub(club: Club)

    suspend fun deleteAll()

    suspend fun getRatingFromClub (name: String): Double

    suspend fun getPlayersRating (name: String): Double

    suspend fun getClubsFromLeague (league: String): List<Club>

    suspend fun getClubsFromLeagueByPosition(league: String): List<Club>

    suspend fun getClubsFromLeagueByRating(league: String): List<Club>

    suspend fun getClub(name: String): Club?
}