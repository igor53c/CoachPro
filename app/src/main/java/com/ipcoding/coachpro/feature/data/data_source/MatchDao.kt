package com.ipcoding.coachpro.feature.data.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ipcoding.coachpro.feature.domain.model.Match
import kotlinx.coroutines.flow.Flow

@Dao
interface MatchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMatch(match: Match)

    @Query("DELETE FROM match_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM match_table WHERE round = :round ORDER BY host ASC")
    suspend fun getMatchesFromRound(round: Int): List<Match>

    @Query("SELECT * FROM match_table ORDER BY round ASC, host ASC")
    fun getAllMatches(): Flow<List<Match>>

    @Query(
        "SELECT * FROM match_table WHERE " +
                "(round = :round AND (host = :clubName OR guest = :clubName))"
    )
    fun getClubMatchFromNextRound(round: Int, clubName: String?): Flow<Match?>

    @Query(
        "SELECT * FROM match_table WHERE " +
                "(round = :round AND (host = :clubName OR guest = :clubName))"
    )
    suspend fun getClubMatch(round: Int, clubName: String?): Match?
}