package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.feature.domain.repository.ClubRepository

class SaveFirstTeamRating(
    private val clubRepository: ClubRepository
) {
    suspend operator fun invoke(clubName: String?, rating: Double) {
        clubName?.let {
            clubRepository.getClub(clubName)?.let { club ->
                club.rating = rating
                clubRepository.insertClub(club)
            }
        }
    }
}