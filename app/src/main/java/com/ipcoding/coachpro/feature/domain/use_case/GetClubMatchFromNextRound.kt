package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.feature.domain.model.Match
import com.ipcoding.coachpro.feature.domain.repository.MatchRepository
import kotlinx.coroutines.flow.Flow

class GetClubMatchFromNextRound(
    private val matchRepository: MatchRepository
) {

    operator fun invoke(round: Int, clubName: String?): Flow<Match?> {
        return matchRepository.getClubMatchFromNextRound(round, clubName)
    }
}