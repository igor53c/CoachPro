package com.ipcoding.coachpro.feature.data.repository

import com.ipcoding.coachpro.feature.domain.model.Player
import com.ipcoding.coachpro.feature.domain.repository.PlayerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PlayerRepositoryFake : PlayerRepository {

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
        return players.filter { it.transferPlayer == false }
    }

    override fun getPlayersSortByNumber(): Flow<List<Player>> {
        return flow { emit(players.filter { it.transferPlayer == false }.sortedBy { it.number }) }
    }

    override fun getPlayersSortByRating(): Flow<List<Player>> {
        return flow { emit(players.filter { it.transferPlayer == false }.sortedBy { it.rating }) }
    }

    override fun getTransferPlayersSortById(): Flow<List<Player>> {
        return flow { emit(players.filter { it.transferPlayer == false }.sortedBy { it.id }) }
    }

    override suspend fun getAllTransferPlayers(): List<Player> {
        return players.filter { it.transferPlayer == true }
    }

    override suspend fun numberOfPlayers(): Int {
        return players.size
    }

    override suspend fun deleteAllTransferPlayers() {
        players.filter { it.transferPlayer == true }.forEach {
            players.remove(it)
        }
    }
}