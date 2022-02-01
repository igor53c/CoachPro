package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.core.util.AllPlayers
import com.ipcoding.coachpro.feature.domain.model.Player
import com.ipcoding.coachpro.feature.domain.repository.PlayerRepository
import kotlin.random.Random

class CreateClubDatabase(
    private val playerRepository: PlayerRepository
) {

    suspend operator fun invoke(clubRating: Double) {
        for (number in 0..17) {
            var position = ""
            when(number) {
                in 0..1 -> position = "GK"
                in 2..7 -> position =
                    arrayOf("DR", "DC", "DL", "DRC", "DRL", "DLC")[Random.nextInt(6)]
                in 8..13 -> position =
                    arrayOf("MR", "MC", "ML", "MRC", "MRL", "MLC")[Random.nextInt(6)]
                in 14..17 -> position =
                    arrayOf("FR", "FC", "FL", "FRC", "FRL", "FLC")[Random.nextInt(6)]
            }
            val rating = takeRandomNumberFromRange(
                Math.round(clubRating - 8).toInt(),
                Math.round(clubRating + 4).toInt()
            )
            val age = if (clubRating - rating < 0) {
                takeRandomNumberFromRange(31, 36)
            } else {
                if (clubRating - rating < 4) {
                    takeRandomNumberFromRange(24, 30)
                } else {
                    takeRandomNumberFromRange(18, 23)
                }
            }
            playerRepository.insertPlayer(
                Player(makeName(), position, rating.toDouble(), age,
                number, 100, 100, 0)
            )
        }
    }

    private fun makeName(): String {
        return takeRandomLetter().toString() + " " +
                AllPlayers().players[Random.nextInt(AllPlayers().playersSize())]
    }

    private fun takeRandomNumberFromRange(min: Int, max: Int): Int {
        return (Math.random() * (max - min + 1)).toInt() + min
    }

    private fun takeRandomLetter(): Char {
        return ('A'.code + Random.nextInt(26)).toChar()
    }
}