package com.ipcoding.coachpro.feature.data.repository

import com.ipcoding.coachpro.feature.data.data_source.MatchDao
import com.ipcoding.coachpro.feature.domain.model.Match
import com.ipcoding.coachpro.feature.domain.repository.MatchRepository
import kotlinx.coroutines.flow.Flow

class MatchRepositoryImpl(
    private val dao: MatchDao
) : MatchRepository {

    override suspend fun insertMatch(match: Match) {
        dao.insertMatch(match)
    }

    override suspend fun deleteAll() {
        dao.deleteAll()
    }

    override suspend fun getMatchesFromRound(round: Int): List<Match> {
        return dao.getMatchesFromRound(round)
    }

    override fun getAllMatches(): Flow<List<Match>> {
        return dao.getAllMatches()
    }

    override fun getClubMatchFromNextRound(round: Int, club: String?): Flow<Match?> {
        return dao.getClubMatchFromNextRound(round, club)
    }

    override suspend fun getClubMatch(round: Int, club: String?): Match? {
        return dao.getClubMatch(round, club)
    }
}