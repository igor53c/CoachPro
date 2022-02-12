package com.ipcoding.coachpro.feature.data.repository

import com.ipcoding.coachpro.feature.domain.model.History
import com.ipcoding.coachpro.feature.domain.repository.HistoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeHistoryRepository : HistoryRepository {

    private var historyList = mutableListOf<History>()

    override suspend fun insertHistory(history: History) {
        historyList.add(history)
    }

    override suspend fun deleteAll() {
        historyList.clear()
    }

    override fun getAllHistory(): Flow<List<History>> {
        return flow { emit(historyList) }
    }
}