package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.feature.domain.model.Player
import com.ipcoding.coachpro.feature.domain.repository.ClubRepository
import com.ipcoding.coachpro.feature.domain.repository.PlayerRepository

class TrainingCalculation(
    private val playerRepository: PlayerRepository,
    private val clubRepository: ClubRepository
) {

    suspend operator fun invoke(playersPlayedMatch: Boolean, clubName: String) {

        val players: List<Player> = playerRepository.getPlayers()
        val club = clubRepository.getClub(clubName)

        for (player in players) {
            if (!playersPlayedMatch) {
                player.motivation += 20
                if (player.motivation > 100) player.motivation = 100
            }
            player.fitness += (4 - player.training) * 20
            if (player.fitness > 100) player.fitness = 100 else
                if (player.fitness < 0) player.fitness = 0

            player.rating += player.training * 0.025 * (player.fitness / 100.0) *
                    (player.motivation / 100.0) + (18 - player.age) * 0.01

            if (player.rating > 99) player.rating = 99.0 else
                if (player.rating < 1) player.rating = 1.0

            playerRepository.insertPlayer(player)
        }

        if (club != null) {
            club.playersRating = CalculationTeamRating()(players)
            clubRepository.insertClub(club)
        }
    }
}