package com.ipcoding.coachpro.feature.data.repository

import com.ipcoding.coachpro.feature.data.data_source.HistoryDao
import com.ipcoding.coachpro.feature.domain.model.History
import com.ipcoding.coachpro.feature.domain.repository.HistoryRepository
import kotlinx.coroutines.flow.Flow

class HistoryRepositoryImpl(
    private val dao: HistoryDao
): HistoryRepository {

    override suspend fun insertHistory(history: History) {
        dao.insertHistory(history)
    }

    override suspend fun deleteAll() {
        dao.deleteAll()
    }

    override fun getAllHistory(): Flow<List<History>> {
        return dao.getAllHistory()
    }
}