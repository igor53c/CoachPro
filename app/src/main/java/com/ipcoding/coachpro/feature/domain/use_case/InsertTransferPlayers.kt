package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.core.util.Constants.ALL_POSITION
import com.ipcoding.coachpro.feature.domain.model.Player
import com.ipcoding.coachpro.feature.domain.repository.PlayerRepository
import kotlin.math.pow

class InsertTransferPlayers(
    private val playerRepository: PlayerRepository
) {

    suspend operator fun invoke(rating: Double) {
        for (number in 0..19) {
            val position = ALL_POSITION.random()
            val ratingPlayer =  randomDouble(rating - 8, rating + 4)

            val age = when {
                ratingPlayer > rating -> (31..36).random()
                ratingPlayer > rating - 4 -> (24..30).random()
                else -> (18..23).random()
            }

            playerRepository.insertPlayer(
                Player(
                    name = makeName(),
                    position = position,
                    rating = ratingPlayer,
                    age = age,
                    number = number,
                    transferPlayer = true,
                    value = getPlayerValue(ratingPlayer, age)
                )
            )
        }
    }
}

fun getPlayerValue(rating: Double, age: Int) : Double {
    val value = (1.06421).pow(rating - 25.0) * (1.0 +  (18.0 - age.toDouble()) / 20.0)
    return when {
        value < 0.0 -> 0.0
        else -> value
    }
}