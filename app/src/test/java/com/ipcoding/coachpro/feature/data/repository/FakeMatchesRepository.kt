package com.ipcoding.coachpro.feature.data.repository

import com.ipcoding.coachpro.feature.domain.model.Matches
import com.ipcoding.coachpro.feature.domain.repository.MatchesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeMatchesRepository : MatchesRepository {

    private var matchesList = mutableListOf<Matches>()

    override suspend fun insertMatches(matches: Matches) {
        matchesList.add(matches)
    }

    override suspend fun deleteAll() {
        matchesList.clear()
    }

    override fun getLastTenMatches(): Flow<List<Matches>> {
        return flow { emit(matchesList) }
    }
}