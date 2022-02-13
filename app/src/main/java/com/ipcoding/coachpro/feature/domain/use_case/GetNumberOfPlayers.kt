package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.feature.domain.repository.PlayerRepository

class GetNumberOfPlayers(
    private val playerRepository: PlayerRepository
) {

    suspend operator fun invoke(): Int {
        return playerRepository.numberOfPlayers()
    }
}