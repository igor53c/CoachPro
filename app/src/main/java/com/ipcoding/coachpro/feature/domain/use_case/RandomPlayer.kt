package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.feature.domain.model.Player
import com.ipcoding.coachpro.feature.domain.repository.PlayerRepository

class RandomPlayer(
    private val playerRepository: PlayerRepository
) {

    suspend operator fun invoke(): Player? {

        val players = playerRepository.getPlayers()

        var player: Player? = null

        if(players.isNotEmpty()) player = players[players.indices.random()]

        player?.let {
            it.value = getRandomPlayerValue(it.rating, it.age)
        }

        return player
    }
}