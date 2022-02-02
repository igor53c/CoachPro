package com.ipcoding.coachpro.feature.data.data_source

import androidx.room.*
import com.ipcoding.coachpro.feature.domain.model.Match
import kotlinx.coroutines.flow.Flow

@Dao
interface MatchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMatch(match: Match)

    @Query("DELETE FROM match_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM match_table WHERE round = :round ORDER BY host ASC")
    fun getMatchesFromRound(round: Int): Flow<List<Match>>

    @Query("SELECT * FROM match_table WHERE " +
            "(round = :round AND (host = :club OR guest = :club))")
    suspend fun getClubMatchFromNextRound (round: Int, club: String?): Match?
}