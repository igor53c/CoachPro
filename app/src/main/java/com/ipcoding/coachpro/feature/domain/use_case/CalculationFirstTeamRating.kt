package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.feature.domain.model.Player

class CalculationFirstTeamRating {

    operator fun invoke(players: List<Player>, tactics: List<Any>): Double {
        var rating = 0.0
        for (i1 in 0..3) {
            val max = tactics[i1 + 1] as Int
            for (i2 in 0..max) {
                GetPlayer().invoke(players, tactics, i1, i2)?.let { player ->
                    if(CheckPlayerInRightPosition().invoke(player, i1, i2, tactics)) {
                        rating +=  player.rating
                    }
                }
            }
        }
        return rating / 11.0
    }
}