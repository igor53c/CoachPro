package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.core.util.InputData.ALL_POSITION
import com.ipcoding.coachpro.feature.domain.model.Player
import com.ipcoding.coachpro.feature.domain.repository.PlayerRepository

class DeletePlayer(
    private val playerRepository: PlayerRepository
) {

    suspend operator fun invoke(player: Player) {
        val playerRating = player.rating
        playerRepository.deletePlayer(player)

        if(playerRepository.numberOfPlayers() < 11)
            playerRepository.insertPlayer(
                Player(
                    name = makeName(),
                    position = ALL_POSITION.random(),
                    rating = randomDouble(playerRating - 20, playerRating - 10),
                    age = 18,
                    number = 12
                )
            )

        val players = playerRepository.getPlayers()
        for(i in 1..players.size) {
            val currentPlayer  = players[i - 1]
            currentPlayer.number = i
            playerRepository.insertPlayer(currentPlayer)
        }
    }
}