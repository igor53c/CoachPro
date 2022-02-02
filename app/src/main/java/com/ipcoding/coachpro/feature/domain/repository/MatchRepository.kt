package com.ipcoding.coachpro.feature.domain.repository

import com.ipcoding.coachpro.feature.domain.model.Match
import kotlinx.coroutines.flow.Flow

interface MatchRepository {

    suspend fun insertMatch(match: Match)

    suspend fun deleteAll()

    fun getMatchesFromRound(round: Int): Flow<List<Match>>

    suspend fun getClubMatchFromNextRound (round: Int, club: String?): Match?
}