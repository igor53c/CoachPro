package com.ipcoding.coachpro.feature.data.repository

import com.ipcoding.coachpro.feature.domain.model.Matches
import com.ipcoding.coachpro.feature.domain.repository.MatchesRepository

class MatchesRepositoryFake : MatchesRepository {

    private var matchesList = mutableListOf<Matches>()

    override suspend fun insertMatches(matches: Matches) {
        matchesList.add(matches)
    }

    override suspend fun deleteAll() {
        matchesList.clear()
    }

    override suspend fun getLastTenMatches(): List<Matches> {
        return  when {
            matchesList.size > 10 -> matchesList.sortedBy { it.id }.subList(0, 10)
            else -> matchesList.sortedBy { it.id }
        }
    }
}