package com.ipcoding.coachpro.feature.domain.use_case

import android.util.Log
import com.ipcoding.coachpro.feature.domain.model.Player

class CalculationTeamRating {

    operator fun invoke(players: List<Player>): Double {
        var rating = 0.0
        Log.d("rating", "rating: $rating")
        for (player in players) {
            rating +=  player.rating
            Log.d("rating", "rating: $rating")
        }
        Log.d("rating", "rating: $rating")
        return rating / players.size.toDouble()
    }
}