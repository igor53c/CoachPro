package com.ipcoding.coachpro.feature.data.data_source

import androidx.room.*
import com.ipcoding.coachpro.feature.domain.model.Club
import kotlinx.coroutines.flow.Flow

@Dao
interface ClubDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertClub(club: Club)

    @Query("DELETE FROM clubs_table")
    suspend fun deleteAll()

    @Query("SELECT rating FROM clubs_table WHERE name = :name")
    suspend fun getRatingFromClub (name: String): Double

    @Query("SELECT * FROM clubs_table WHERE " +
            "league = :league ORDER BY points DESC, goalDifference DESC")
    fun getClubsFromLeague (league: String): Flow<List<Club>>

    @Query("SELECT * FROM clubs_table WHERE league = :league ORDER BY position ASC")
    fun getClubsFromLeagueByPosition(league: String): Flow<List<Club>>

    @Query("SELECT * FROM clubs_table WHERE league = :league ORDER BY rating DESC")
    fun getClubsFromLeagueByRating(league: String): Flow<List<Club>>

    @Query("SELECT * FROM clubs_table WHERE name = :club")
    suspend fun getClub(club: String): Club?
}