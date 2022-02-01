package com.ipcoding.coachpro.feature.domain.repository

import com.ipcoding.coachpro.feature.domain.model.Player
import kotlinx.coroutines.flow.Flow

interface PlayerRepository {

    fun getPlayers(): Flow<List<Player>>

    suspend fun getPlayerById(id: Int?): Player?

    suspend fun insertPlayer(player: Player)

    suspend fun deletePlayer(player: Player)
}