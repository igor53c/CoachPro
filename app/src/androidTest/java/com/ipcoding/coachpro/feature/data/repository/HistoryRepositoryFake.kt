package com.ipcoding.coachpro.feature.data.repository

import com.ipcoding.coachpro.feature.domain.model.History
import com.ipcoding.coachpro.feature.domain.repository.HistoryRepository

class HistoryRepositoryFake : HistoryRepository {

    private var historyList = mutableListOf<History>()

    override suspend fun insertHistory(history: History) {
        historyList.add(history)
    }

    override suspend fun deleteAll() {
        historyList.clear()
    }

    override suspend fun getAllHistory(): List<History> {
        return historyList
    }

    override suspend fun numberOfYears(): Int {
        return historyList.size
    }
}