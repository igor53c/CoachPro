package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.feature.domain.model.Player
import com.ipcoding.coachpro.feature.domain.repository.PlayerRepository

class GetPlayers(
    private val playerRepository: PlayerRepository
) {

    suspend operator fun invoke(): List<Player> {
        return playerRepository.getPlayersSortByNumber()
    }
}