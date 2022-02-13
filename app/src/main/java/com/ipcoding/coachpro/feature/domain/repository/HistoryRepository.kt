package com.ipcoding.coachpro.feature.domain.repository

import com.ipcoding.coachpro.feature.domain.model.History

interface HistoryRepository {

    suspend fun insertHistory(history: History)

    suspend fun deleteAll()

    suspend fun getAllHistory():List<History>

    suspend fun numberOfYears(): Int
}