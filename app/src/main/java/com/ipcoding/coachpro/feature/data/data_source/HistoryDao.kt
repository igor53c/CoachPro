package com.ipcoding.coachpro.feature.data.data_source

import androidx.room.*
import com.ipcoding.coachpro.feature.domain.model.History
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHistory(history: History)

    @Query("DELETE FROM history_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM history_table ORDER BY year DESC")
    fun getAllHistory(): Flow<List<History>>
}