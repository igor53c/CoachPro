package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.feature.domain.repository.ClubRepository

class GetPlayersRating(
    private val clubRepository: ClubRepository
) {
    suspend operator fun invoke(clubName: String?): Double? {
        return clubName?.let { clubRepository.getPlayersRating(it) }
    }
}