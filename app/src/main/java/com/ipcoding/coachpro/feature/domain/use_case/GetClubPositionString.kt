package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.feature.domain.repository.ClubRepository

class GetClubPositionString(
    private val clubRepository: ClubRepository
) {

    suspend operator fun invoke(name: String): String {
        return clubRepository.getClub(name)?.position?.let {
            positionString(it)
        }.toString()
    }
}

fun positionString(position: Int): String {
    return when (position) {
        1 -> "${position}st"
        2 -> "${position}nd"
        3 -> "${position}rd"
        else -> "${position}th"
    }
}