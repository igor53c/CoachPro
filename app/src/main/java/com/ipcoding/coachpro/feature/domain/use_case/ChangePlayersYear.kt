package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.feature.domain.model.Player
import com.ipcoding.coachpro.feature.domain.repository.PlayerRepository

class ChangePlayersYear(
    private val playerRepository: PlayerRepository
) {

    suspend fun invoke() {

        val players: List<Player> = playerRepository.getPlayers()
        for (player in players) {
            player.age += 1
            playerRepository.insertPlayer(player)
        }
    }
}