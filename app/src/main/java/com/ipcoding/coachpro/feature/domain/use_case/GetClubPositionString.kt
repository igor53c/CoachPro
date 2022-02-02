package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.feature.domain.repository.ClubRepository

class GetClubPositionString(
    private val clubRepository: ClubRepository
) {

    suspend operator fun invoke(name: String): String {
        val end: String
        val position = clubRepository.getClub(name)?.position.toString()
        end = when(position) {
            "1" -> "st"
            "2" -> "nd"
            "3" -> "rd"
            else -> "th"
        }
        return position + end
    }
}