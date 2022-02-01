package com.ipcoding.coachpro.feature.data.data_source

import androidx.room.*
import com.ipcoding.coachpro.feature.domain.model.Player
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDao {

    @Query("SELECT * FROM player")
    fun getPlayers(): Flow<List<Player>>

    @Query("SELECT * FROM player WHERE id = :id")
    suspend fun getPlayerById(id: Int?): Player?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayer(player: Player)

    @Delete
    suspend fun deletePlayer(player: Player)
}