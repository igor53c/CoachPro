package com.ipcoding.coachpro.feature.domain.repository

import com.ipcoding.coachpro.feature.domain.model.Match
import kotlinx.coroutines.flow.Flow

interface MatchRepository {

    suspend fun insertMatch(match: Match)

    suspend fun deleteAll()

    suspend fun getMatchesFromRound(round: Int): List<Match>

    fun getAllMatches(): Flow<List<Match>>

    fun getClubMatchFromNextRound(round: Int, club: String?): Flow<Match?>

    suspend fun getClubMatch(round: Int, club: String?): Match?
}