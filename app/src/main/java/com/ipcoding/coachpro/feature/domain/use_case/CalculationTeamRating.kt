package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.feature.domain.model.Player

class CalculationTeamRating {

    operator fun invoke(players: List<Player>): Double {
        var rating = 0.0
        for (player in players) {
            rating +=  player.rating
        }
        return rating / players.size.toDouble()
    }
}