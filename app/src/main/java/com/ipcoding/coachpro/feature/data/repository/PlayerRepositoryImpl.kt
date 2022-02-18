package com.ipcoding.coachpro.feature.data.repository

import com.ipcoding.coachpro.feature.data.data_source.PlayerDao
import com.ipcoding.coachpro.feature.domain.model.Player
import com.ipcoding.coachpro.feature.domain.repository.PlayerRepository
import kotlinx.coroutines.flow.Flow

class PlayerRepositoryImpl(
    private val dao: PlayerDao
) : PlayerRepository {
    override suspend fun insertPlayer(player: Player) {
        dao.insertPlayer(player)
    }

    override suspend fun deletePlayer(player: Player) {
        dao.deletePlayer(player)
    }

    override suspend fun deleteAll() {
        dao.deleteAll()
    }

    override suspend fun getPlayerById(id: Int?): Player? {
        return dao.getPlayerById(id)
    }

    override suspend fun getPlayers(): List<Player> {
        return dao.getPlayers()
    }

    override fun getPlayersSortByNumber(): Flow<List<Player>> {
        return dao.getPlayersSortByNumber()
    }

    override fun getPlayersSortByRating(): Flow<List<Player>> {
        return dao.getPlayersSortByRating()
    }

    override fun getTransferPlayersSortById(): Flow<List<Player>> {
        return dao.getTransferPlayersSortById()
    }

    override suspend fun getAllTransferPlayers(): List<Player> {
        return dao.getAllTransferPlayers()
    }

    override suspend fun numberOfPlayers(): Int {
        return dao.numberOfPlayers()
    }

    override suspend fun deleteAllTransferPlayers() {
        dao.deleteAllTransferPlayers()
    }
}