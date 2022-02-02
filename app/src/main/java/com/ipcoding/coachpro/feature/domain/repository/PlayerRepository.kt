package com.ipcoding.coachpro.feature.domain.repository

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ipcoding.coachpro.feature.domain.model.Player
import kotlinx.coroutines.flow.Flow

interface PlayerRepository {

    suspend fun insertPlayer(player: Player)

    suspend fun deletePlayer(player: Player)

    suspend fun deleteAll()

    suspend fun getPlayerById(id: Int?): Player?

    fun getPlayers(): Flow<List<Player>>

    fun getPlayersSortByNumber(): Flow<List<Player>>

    fun getPlayersSortbyRating(): Flow<List<Player>>
}