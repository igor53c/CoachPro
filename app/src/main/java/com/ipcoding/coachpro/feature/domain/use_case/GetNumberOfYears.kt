package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.feature.domain.repository.HistoryRepository

class GetNumberOfYears(
    private val historyRepository: HistoryRepository
) {

    suspend operator fun invoke(): Int {
        return historyRepository.numberOfYears()
    }
}