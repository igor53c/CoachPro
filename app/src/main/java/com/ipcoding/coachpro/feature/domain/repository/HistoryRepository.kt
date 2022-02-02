package com.ipcoding.coachpro.feature.domain.repository

import com.ipcoding.coachpro.feature.domain.model.History
import kotlinx.coroutines.flow.Flow

interface HistoryRepository {

    suspend fun insertHistory(history: History)

    suspend fun deleteAll()

    fun getAllHistory(): Flow<List<History>>
}