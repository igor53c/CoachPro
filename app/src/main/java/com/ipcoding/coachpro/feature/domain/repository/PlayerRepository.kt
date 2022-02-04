package com.ipcoding.coachpro.feature.domain.repository

import com.ipcoding.coachpro.feature.domain.model.Player
import kotlinx.coroutines.flow.Flow

interface PlayerRepository {

    suspend fun insertPlayer(player: Player)

    suspend fun deletePlayer(player: Player)

    suspend fun deleteAll()

    suspend fun getPlayerById(id: Int?): Player?

    fun getPlayers(): Flow<List<Player>>

    fun getPlayersSortByNumber(): Flow<List<Player>>

    fun getPlayersSortByRating(): Flow<List<Player>>
}