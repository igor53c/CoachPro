package com.ipcoding.coachpro.feature.data.data_source

import androidx.room.*
import com.ipcoding.coachpro.feature.domain.model.Player
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayer(player: Player)

    @Delete
    suspend fun deletePlayer(player: Player)

    @Query("DELETE FROM players_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM players_table WHERE id = :id")
    suspend fun getPlayerById(id: Int?): Player?

    @Query("SELECT * FROM players_table")
    fun getPlayers(): Flow<List<Player>>

    @Query("SELECT * FROM players_table ORDER BY number ASC")
    fun getPlayersSortByNumber(): Flow<List<Player>>

    @Query("SELECT * FROM players_table ORDER BY rating DESC")
    fun getPlayersSortbyRating(): Flow<List<Player>>
}