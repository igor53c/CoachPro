package com.ipcoding.coachpro.feature.data.repository

import com.ipcoding.coachpro.feature.data.data_source.MatchesDao
import com.ipcoding.coachpro.feature.domain.model.Matches
import com.ipcoding.coachpro.feature.domain.repository.MatchesRepository

class MatchesRepositoryImpl(
    private val dao: MatchesDao
) : MatchesRepository {

    override suspend fun insertMatches(matches: Matches) {
        dao.insertMatches(matches)
    }

    override suspend fun deleteAll() {
        dao.deleteAll()
    }

    override suspend fun getLastTenMatches(): List<Matches> {
        return dao.getLastTenMatches()
    }
}