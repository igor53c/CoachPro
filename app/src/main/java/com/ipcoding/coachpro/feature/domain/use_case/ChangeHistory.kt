package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.feature.domain.model.History
import com.ipcoding.coachpro.feature.domain.repository.ClubRepository
import com.ipcoding.coachpro.feature.domain.repository.HistoryRepository

class ChangeHistory(
    private val clubRepository: ClubRepository,
    private val historyRepository: HistoryRepository
) {

    suspend operator fun invoke(league: String, year: Int, clubName: String) {

        clubRepository.getClub(clubName)
            ?.let { History(year, "League $league", it.position) }?.let {
                historyRepository.insertHistory(it)
            }
    }
}