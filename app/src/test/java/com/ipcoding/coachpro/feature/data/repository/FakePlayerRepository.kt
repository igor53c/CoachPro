package com.ipcoding.coachpro.feature.data.repository

import com.ipcoding.coachpro.feature.domain.model.Player
import com.ipcoding.coachpro.feature.domain.repository.PlayerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakePlayerRepository : PlayerRepository {

    private var players = mutableListOf<Player>()

    override suspend fun insertPlayer(player: Player) {
        players.add(player)
    }

    override suspend fun deletePlayer(player: Player) {
        players.remove(player)
    }

    override suspend fun deleteAll() {
        players.clear()
    }

    override suspend fun getPlayerById(id: Int?): Player? {
       return players.find { it.id == id }
    }

    override suspend fun getPlayers(): List<Player> {
        return players
    }

    override fun getPlayersSortByNumber(): Flow<List<Player>> {
        return flow { emit(players.sortedBy { it.number }) }
    }

    override fun getPlayersSortByRating(): Flow<List<Player>> {
        return flow { emit(players.sortedBy { it.rating }) }
    }
}