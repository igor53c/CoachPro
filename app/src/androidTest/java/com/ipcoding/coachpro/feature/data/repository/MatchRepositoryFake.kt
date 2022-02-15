package com.ipcoding.coachpro.feature.data.repository

import com.ipcoding.coachpro.feature.domain.model.Match
import com.ipcoding.coachpro.feature.domain.repository.MatchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MatchRepositoryFake : MatchRepository {

    private var matches = mutableListOf<Match>()

    override suspend fun insertMatch(match: Match) {
        matches.add(match)
    }

    override suspend fun deleteAll() {
        matches.clear()
    }

    override suspend fun getMatchesFromRound(round: Int): List<Match> {
        return matches.filter { it.round == round }
    }

    override fun getAllMatches(): Flow<List<Match>> {
        return flow { emit(matches) }
    }

    override fun getClubMatchFromNextRound(round: Int, club: String?): Flow<Match?> {
        return flow { emit(matches.find {
            it.round == round && (it.host == club || it.guest == club)
        }) }
    }

    override suspend fun getClubMatch(round: Int, club: String?): Match? {
        return matches.find { it.round == round && (it.host == club || it.guest == club) }
    }
}