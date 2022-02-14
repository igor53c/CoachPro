package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.feature.domain.model.Player
import com.ipcoding.coachpro.feature.domain.repository.PlayerRepository
import kotlinx.coroutines.flow.Flow

class GetTransferPlayers(
    private val playerRepository: PlayerRepository
) {

    operator fun invoke(): Flow<List<Player>> {
        return playerRepository.getTransferPlayersSortById()
    }
}