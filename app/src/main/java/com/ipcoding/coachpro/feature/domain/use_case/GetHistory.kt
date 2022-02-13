package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.feature.domain.model.History
import com.ipcoding.coachpro.feature.domain.repository.HistoryRepository

class GetHistory(
    private val historyRepository: HistoryRepository
) {

    suspend operator fun invoke(): List<History> {
        return historyRepository.getAllHistory()
    }
}