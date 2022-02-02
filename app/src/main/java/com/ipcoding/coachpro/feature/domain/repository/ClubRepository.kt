package com.ipcoding.coachpro.feature.domain.repository

import com.ipcoding.coachpro.feature.domain.model.Club
import kotlinx.coroutines.flow.Flow

interface ClubRepository {

    suspend fun insertClub(club: Club)

    suspend fun deleteAll()

    suspend fun getRatingFromClub (name: String): Double

    fun getClubsFromLeague (league: String): Flow<List<Club>>

    fun getClubsFromLeagueByPosition(league: String): Flow<List<Club>>

    fun getClubsFromLeagueByRating(league: String): Flow<List<Club>>

    suspend fun getClub(club: String): Club?
}