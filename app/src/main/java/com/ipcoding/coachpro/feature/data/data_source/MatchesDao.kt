package com.ipcoding.coachpro.feature.data.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ipcoding.coachpro.feature.domain.model.Matches
import kotlinx.coroutines.flow.Flow

@Dao
interface MatchesDao {

    @Insert
    suspend fun insertMatches(matches: Matches)

    @Query("DELETE FROM matches_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM matches_table ORDER BY id DESC LIMIT 10")
    fun getLastTenMatches (): Flow<List<Matches>>
}