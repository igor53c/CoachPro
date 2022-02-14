package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.feature.domain.model.Player
import com.ipcoding.coachpro.feature.domain.repository.PlayerRepository

class DeletePlayer(
    private val playerRepository: PlayerRepository
) {

    suspend operator fun invoke(player: Player) {
        playerRepository.deletePlayer(player)
    }
}