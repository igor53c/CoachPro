package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.feature.domain.model.Club
import com.ipcoding.coachpro.feature.domain.repository.ClubRepository

class GetClubsFromLeagueByPosition(
    private val clubRepository: ClubRepository
) {

    suspend operator fun invoke(league: String): List<Club> {
        return clubRepository.getClubsFromLeagueByPosition(league)
    }
}