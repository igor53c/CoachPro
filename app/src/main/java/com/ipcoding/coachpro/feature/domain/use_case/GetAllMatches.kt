package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.feature.domain.model.Match
import com.ipcoding.coachpro.feature.domain.repository.MatchRepository
import kotlinx.coroutines.flow.Flow

class GetAllMatches(
    private val matchRepository: MatchRepository
) {

    operator fun invoke(): Flow<List<Match>> {
        return matchRepository.getAllMatches()
    }
}