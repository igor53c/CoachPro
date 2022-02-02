package com.ipcoding.coachpro.feature.domain.repository

import com.ipcoding.coachpro.feature.domain.model.Matches
import kotlinx.coroutines.flow.Flow

interface MatchesRepository {

    suspend fun insertMatches(matches: Matches)

    suspend fun deleteAll()

    fun getLastTenMatches (): Flow<List<Matches>>
}