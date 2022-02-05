package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.feature.domain.repository.ClubRepository

class GetClubRating(
    private val clubRepository: ClubRepository
) {
    suspend operator fun invoke(clubName: String?): Double? {
        return clubName?.let { clubRepository.getRatingFromClub(it) }
    }
}