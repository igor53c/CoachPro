package com.ipcoding.coachpro.feature.domain.repository

import com.ipcoding.coachpro.feature.domain.model.Matches

interface MatchesRepository {

    suspend fun insertMatches(matches: Matches)

    suspend fun deleteAll()

    suspend fun getLastTenMatches (): List<Matches>
}