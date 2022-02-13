package com.ipcoding.coachpro.feature.data.data_source

import androidx.room.*
import com.ipcoding.coachpro.feature.domain.model.History

@Dao
interface HistoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHistory(history: History)

    @Query("DELETE FROM history_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM history_table ORDER BY year DESC")
    suspend fun getAllHistory(): List<History>

    @Query("SELECT COUNT(*) FROM history_table")
    suspend fun numberOfYears(): Int
}