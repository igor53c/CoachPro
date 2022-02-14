package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.feature.domain.model.Player
import com.ipcoding.coachpro.feature.domain.repository.PlayerRepository

class RandomPlayer(
    private val playerRepository: PlayerRepository
) {

    suspend operator fun invoke(): Player {

        val players = playerRepository.getPlayers()

        val player = players[players.indices.random()]

        player.value = getRandomPlayerValue(player.rating, player.age)

        return player
    }
}