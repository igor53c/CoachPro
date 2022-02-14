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

    @Query("SELECT * FROM players_table WHERE NOT transferPlayer ORDER BY number ASC")
    suspend fun getPlayers(): List<Player>

    @Query("SELECT * FROM players_table WHERE NOT transferPlayer ORDER BY number ASC")
    fun getPlayersSortByNumber(): Flow<List<Player>>

    @Query("SELECT * FROM players_table WHERE NOT transferPlayer ORDER BY rating DESC")
    fun getPlayersSortByRating(): Flow<List<Player>>

    @Query("SELECT * FROM players_table WHERE transferPlayer ORDER BY id ASC")
    fun getTransferPlayersSortById(): Flow<List<Player>>

    @Query("SELECT * FROM players_table WHERE transferPlayer ORDER BY id ASC")
    suspend fun getAllTransferPlayers(): List<Player>

    @Query("SELECT COUNT(*) FROM players_table WHERE NOT transferPlayer")
    suspend fun numberOfPlayers(): Int

    @Query("DELETE FROM players_table WHERE transferPlayer")
    suspend fun deleteAllTransferPlayers()
}