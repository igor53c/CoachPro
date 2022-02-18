package com.ipcoding.coachpro.feature.domain.use_case

import androidx.compose.ui.graphics.Color
import com.ipcoding.coachpro.feature.domain.util.MarkedPlayer
import com.ipcoding.coachpro.feature.domain.repository.PlayerRepository

class ReplaceTwoPlayers(
    private val playerRepository: PlayerRepository
) {

    suspend operator fun invoke(
        previouslyClickedInfo: MarkedPlayer,
        item1: Int,
        item2: Int,
        color: Color
    ): MarkedPlayer {
        val returnMarkedPlayer = MarkedPlayer()
        if (!(previouslyClickedInfo.item1 == item1 && previouslyClickedInfo.item2 == item2)) {
            when (previouslyClickedInfo.isPlayerClicked) {
                true -> {
                    previouslyClickedInfo.player?.let { player1 ->
                        previouslyClickedInfo.newPlayer?.let { player2 ->
                            val number = player1.number
                            player1.number = player2.number
                            player2.number = number
                            playerRepository.insertPlayer(player1)
                            playerRepository.insertPlayer(player2)
                        }
                    }
                }
                false -> {
                    returnMarkedPlayer.player = previouslyClickedInfo.newPlayer
                    returnMarkedPlayer.item1 = item1
                    returnMarkedPlayer.item2 = item2
                    returnMarkedPlayer.color = color
                    returnMarkedPlayer.isPlayerClicked = true
                }
            }
        }
        return returnMarkedPlayer
    }
}
