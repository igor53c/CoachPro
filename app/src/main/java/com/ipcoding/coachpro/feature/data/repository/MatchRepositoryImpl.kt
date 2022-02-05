package com.ipcoding.coachpro.feature.data.repository

import com.ipcoding.coachpro.feature.data.data_source.MatchDao
import com.ipcoding.coachpro.feature.domain.model.Match
import com.ipcoding.coachpro.feature.domain.repository.MatchRepository
import kotlinx.coroutines.flow.Flow

class MatchRepositoryImpl(
    private val dao: MatchDao
): MatchRepository {

    override suspend fun insertMatch(match: Match) {
        dao.insertMatch(match)
    }

    override suspend fun deleteAll() {
        dao.deleteAll()
    }

    override fun getMatchesFromRound(round: Int): Flow<List<Match>> {
        return dao.getMatchesFromRound(round)
    }

    override fun getAllMatches(): Flow<List<Match>> {
        return dao.getAllMatches()
    }

    override suspend fun getClubMatchFromNextRound(round: Int, club: String?): Match? {
        return dao.getClubMatchFromNextRound(round, club)
    }
}